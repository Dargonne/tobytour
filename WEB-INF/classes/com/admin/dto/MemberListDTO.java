package com.admin.dto;

import java.sql.Timestamp;

public class MemberListDTO {
	private int memberNum;
	private String memberID; 
	private String memberName; 
	private String memberPhone; 
	private Timestamp memberJoinDate; 
	private int memberUserSection;
	
	public int getMemberNum() {
		return memberNum;
	}
	
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
	public String getMemberID() {
		return memberID;
	}
	
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberPhone() {
		return memberPhone;
	}
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public Timestamp getMemberJoinDate() {
		return memberJoinDate;
	}
	
	public void setMemberJoinDate(Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	
	public int getMemberUserSection() {
		return memberUserSection;
	}
	
	public void setMemberUserSection(int memberUserSection) {
		this.memberUserSection = memberUserSection;
	} 
		
}
