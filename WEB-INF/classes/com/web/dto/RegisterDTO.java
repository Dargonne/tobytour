package com.web.dto;

public class RegisterDTO {
	private String userID; 
	private String userPassword; 
	private String userName; 
	private int userSex; 
	private String userAddress; 
	private int userEmailReceive;
	private String userBirth;
	private String userPhone; 
	
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserSex() {
		return userSex;
	}
	
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public int getUserEmailReceive() {
		return userEmailReceive;
	}
	
	public void setUserEmailReceive(int userEmailReceive) {
		this.userEmailReceive = userEmailReceive;
	} 
	
}
