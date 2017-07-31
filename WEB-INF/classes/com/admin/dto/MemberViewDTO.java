package com.admin.dto;

import java.sql.Timestamp;

public class MemberViewDTO {
	private String memberID; 
	private String memberName; 
	private String memberBirth; 
	private int memberSex; 
	private String memberAddress;
	private String memberPhone; 
	private int memberEmailReceive;
	private Timestamp memberRestStatus; 
	private Timestamp memberJoinDate; 
	private Timestamp memberLatestDate; 
	private int memberUserSection;
	
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
	
	public String getMemberBirth() {
		return memberBirth;
	}
	
	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}
	
	public int getMemberSex() {
		return memberSex;
	}
	
	public void setMemberSex(int memberSex) {
		this.memberSex = memberSex;
	}
	
	public String getMemberAddress() {
		return memberAddress;
	}
	
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	
	public String getMemberPhone() {
		return memberPhone;
	}
	
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	
	public int getMemberEmailReceive() {
		return memberEmailReceive;
	}
	
	public void setMemberEmailReceive(int memberEmailReceive) {
		this.memberEmailReceive = memberEmailReceive;
	}
	
	public Timestamp getMemberRestStatus() {
		return memberRestStatus;
	}
	
	public void setMemberRestStatus(Timestamp memberRestStatus) {
		this.memberRestStatus = memberRestStatus;
	}
	
	public Timestamp getMemberJoinDate() {
		return memberJoinDate;
	}
	
	public void setMemberJoinDate(Timestamp memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}
	
	public Timestamp getMemberLatestDate() {
		return memberLatestDate;
	}
	
	public void setMemberLatestDate(Timestamp memberLatestDate) {
		this.memberLatestDate = memberLatestDate;
	}
	
	public int getMemberUserSection() {
		return memberUserSection;
	}
	
	public void setMemberUserSection(int memberUserSection) {
		this.memberUserSection = memberUserSection;
	} 
	
}
