package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.AppUser;

public class UserMapper implements RowMapper<AppUser>{
	
	public static final String BASE_SQL = "select * from user";

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException{
		int id = rs.getInt("user_id");
		String email = rs.getString("user_email");
		String pass = rs.getString("user_password");
		String fullName = rs.getString("user_fullname");
		String avatar = rs.getString("user_avatar");
		String username = rs.getString("user_username");
		String phone = rs.getString("user_phone");
		int role = rs.getInt("user_role");
		int status = rs.getInt("user_status");
		
		return new AppUser(id, username, email, pass, fullName, avatar, phone,
				role, status);
		
	}
	
}
