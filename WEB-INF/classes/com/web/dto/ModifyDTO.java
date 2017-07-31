package com.web.dto;

public class ModifyDTO {
	private String pass;
	private String name;
	private String birth;
	private String sex;
	private String address;
	private String phone;
	private int emailrecieve;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmailrecieve() {
		return emailrecieve;
	}

	public void setEmailrecieve(int emailrecieve) {
		this.emailrecieve = emailrecieve;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
