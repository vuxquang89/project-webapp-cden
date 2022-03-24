package com.example.demo.form;

public class UserInfoForm {

	private String fullName;
	private String email;
	private String h_email;
	private String phone;
	private String h_phone;
	private String avatar;
	
	public UserInfoForm() {}
	
	public UserInfoForm(String fullName, String email, String h_email, String phone, String h_phone, String avatar) {
		
		this.fullName = fullName;
		this.email = email;
		this.h_email = h_email;
		this.phone = phone;
		this.h_phone = h_phone;
		this.avatar = avatar;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getH_email() {
		return h_email;
	}

	public void setH_email(String h_email) {
		this.h_email = h_email;
	}

	public String getH_phone() {
		return h_phone;
	}

	public void setH_phone(String h_phone) {
		this.h_phone = h_phone;
	}
	
	
}
