package com.admin.dto;

public class LoginAdminDTO {
	private String adminID;  
	private int userSection;
	private String adminPassword; 
	
	public String getAdminID() {
		return adminID;
	}
	
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	
	public int getUserSection() {
		return userSection;
	}
	
	public void setUserSection(int userSection) {
		this.userSection = userSection;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	

}
