package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Spring Security để có thể mật mã hóa (encode) 
 * mật khẩu của người dùng trước khi lưu vào cơ sở dữ liệu.
 * cần phải khai báo một Spring BEAN cho việc mật mã hóa mật khẩu.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	
	private AppConfig appConfig;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 

		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		// Và sét đặt PasswordEncoder.
		appConfig = new AppConfig();
		auth.userDetailsService(this.userDetailsService).passwordEncoder(appConfig.passwordEncoder());
		
	}
	/*
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	*/
	// Ghi đè phương thức này với Code rỗng
	// để vô hiệu hóa Security mặc định của Spring Boot.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		//các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/", "/login", "/logout","/register").permitAll();
		
		// Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.
		http.authorizeRequests().antMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_ROOT')");
		
		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/admin", "/admin/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT')");

		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		// Cấu hình remember me, thời gian là 3 * 24 * 60 * 60 giây
	    http.rememberMe().key("cden20221301dncity").tokenValiditySeconds(3 * 24 * 60 * 60);

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL xu ly login
				.loginPage("/login")//hien thi trang login
				.defaultSuccessUrl("/loginAccount")//dang nhap thanh cong
				.failureUrl("/login?error")//loi dang nhap
				//.failureForwardUrl("/fail_login")
				.usernameParameter("username")//lay gia tri username tu form
				.passwordParameter("password")//lay gia trị passwrord từ form
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login");
	}

}
