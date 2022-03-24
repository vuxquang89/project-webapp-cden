package com.example.demo.form;

public class UserForm {

	private int id;
	private String username;
	private String email;
	private String pass;
	private String confirmPass;
	private String fullName;
	private String avatar;
	private String phone;
	
	
	public UserForm() {}
	

	public UserForm(int id, String username, String email, String pass, String confirmPass, String fullName,
			String avatar, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.confirmPass = confirmPass;
		this.fullName = fullName;
		this.avatar = avatar;
		this.phone = phone;
	}

	public UserForm(int id, String username, String email, String pass, String fullName, String avatar, String phone) {
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.fullName = fullName;
		this.avatar = avatar;
		this.phone = phone;
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
	
	public String getConfirmPass() {
		return confirmPass;
	}


	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
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
	
	
}
