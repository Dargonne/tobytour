package com.web.dto;

import java.sql.Timestamp;

public class WebRequestDTO {

	private String requestSeq; 
	private String requestSection; 
	private String requestID; 
	private String requestMail; 
	private String requestPhone; 
	private String requestTitle; 
	private String requestContent; 
	private String requestReplyContent;
	private Timestamp requestWriteDate; 
	private Timestamp requestReplyDate; 
	private String requestUserName; 
	private String requestUserPhone; 
	private int requestReplyStatus;
	
	
	
	public String getRequestUserName() {
		return requestUserName;
	}

	public void setRequestUserName(String requestUserName) {
		this.requestUserName = requestUserName;
	}

	public String getRequestUserPhone() {
		return requestUserPhone;
	}

	public void setRequestUserPhone(String requestUserPhone) {
		this.requestUserPhone = requestUserPhone;
	}

	public String getRequestReplyContent() {
		return requestReplyContent;
	}

	public void setRequestReplyContent(String requestReplyContent) {
		this.requestReplyContent = requestReplyContent;
	}

	public String getRequestSeq() {
		return requestSeq;
	}
	
	public void setRequestSeq(String requestSeq) {
		this.requestSeq = requestSeq;
	}
	
	public String getRequestSection() {
		return requestSection;
	}
	
	public void setRequestSection(String requestSection) {
		this.requestSection = requestSection;
	}
	
	public String getRequestID() {
		return requestID;
	}
	
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	
	public String getRequestMail() {
		return requestMail;
	}
	
	public void setRequestMail(String requestMail) {
		this.requestMail = requestMail;
	}
	
	public String getRequestPhone() {
		return requestPhone;
	}
	
	public void setRequestPhone(String requestPhone) {
		this.requestPhone = requestPhone;
	}
	
	public String getRequestTitle() {
		return requestTitle;
	}
	
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	
	public String getRequestContent() {
		return requestContent;
	}
	
	public void setRequestContent(String requestContent) {
		this.requestContent = requestContent;
	}
	
	public Timestamp getRequestWriteDate() {
		return requestWriteDate;
	}
	
	public void setRequestWriteDate(Timestamp requestWriteDate) {
		this.requestWriteDate = requestWriteDate;
	}
	
	public Timestamp getRequestReplyDate() {
		return requestReplyDate;
	}
	
	public void setRequestReplyDate(Timestamp requestReplyDate) {
		this.requestReplyDate = requestReplyDate;
	}
	
	public int getRequestReplyStatus() {
		return requestReplyStatus;
	}
	
	public void setRequestReplyStatus(int requestReplyStatus) {
		this.requestReplyStatus = requestReplyStatus;
	} 

	
}
