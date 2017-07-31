package com.web.dto;

public class LoginDTO {
	String id = null;
	String pass = null;
	int userSection = 0;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUserSection() {
		return userSection;
	}
	public void setUserSection(int userSection) {
		this.userSection = userSection;
	}
}
