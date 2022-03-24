package com.example.demo.controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//@RequestMapping("admin")
public class LoginController {
	
	/*login page*/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {		
		return "login";
	}

	/*view info account page*/
	@RequestMapping(value = "/loginAccount", method = RequestMethod.GET)
	public String loginAccount(RedirectAttributes rAttributes, Principal principal) {
		//String username = principal.getName();
		User loginedUser = (User)((Authentication) principal).getPrincipal();
		String role = getRole(loginedUser.getAuthorities());
		System.out.println(role);
		if(role.equals("ROLE_USER")) {
			return "redirect:index";
		}else if(role.equals("ROLE_ADMIN") || role.equals("ROLE_ROOT")) {
			return "redirect:admin";
		}
		
		return "redirect:index";
	}
	
	/*error when user login do not have permission to access this page*/
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		if(principal != null) {
			User loginedUser = (User)((Authentication) principal).getPrincipal();
			model.addAttribute("userInfo", loginedUser);
			String message = "Chào " + principal.getName() + "<br> Bạn không có quyền truy cập trang này!";
			model.addAttribute("message",message);
		}
		return "403page";
	}
	
	/*get role*/
	private String getRole(Collection<GrantedAuthority> authorities) {
		String role = "";
		if(authorities != null && !authorities.isEmpty()) {
			for(GrantedAuthority authority : authorities) {
				role = authority.getAuthority();
			}
		}
		return role;
	}
}
