package com.example.demo.model;

public class AppUser {

	private int id;
	private String username;
	private String email;
	private String pass;
	private String fullName;
	private String avatar;
	private String phone;
	private int role;
	private int status;
	
	public AppUser() {}
	
	public AppUser(int id, String username, String email, String pass, String fullName, String avatar, String phone,
			int role, int status) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.fullName = fullName;
		this.avatar = avatar;
		this.phone = phone;
		this.role = role;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
