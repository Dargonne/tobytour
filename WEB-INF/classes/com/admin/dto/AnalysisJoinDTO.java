package com.admin.dto;

import java.sql.Timestamp;

public class AnalysisJoinDTO {
	/*--------------------- 신규회원 정보 DTO 시작 ---------------------*/
	private Timestamp newMemberJoinDate; 
	private int newMemberJoinCount;
	
	 
	public Timestamp getNewMemberJoinDate() {
		return newMemberJoinDate;
	}
	 
	public void setNewMemberJoinDate(Timestamp newMemberJoinDate) {
		this.newMemberJoinDate = newMemberJoinDate;
	}
		
	public int getNewMemberJoinCount() {
		return newMemberJoinCount;
	}
	
	public void setNewMemberJoinCount(int newMemberJoinCount) {
		this.newMemberJoinCount = newMemberJoinCount;
	}
	
}
