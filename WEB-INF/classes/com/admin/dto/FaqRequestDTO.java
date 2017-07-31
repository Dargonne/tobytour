package com.admin.dto;

import java.sql.Timestamp;;

public class FaqRequestDTO {

	/*
	 *
	private String requestSeq; //문의 번호
	private String requestSection; // 문의 구분(해외여행 or 국내여행)
	private String requestID; // 고객의 ID
	private String requestMail; // 답변을 회신받고 싶은 메일
	private String requestPhone; // 고객의 전화번호
	private String requestTitle; // 고객 문의사항 제목
	private String requestContent; // 고객 문의사항 내용
	private String requestReplyContent; // 담당자 답변사항 내용
	private Timestamp requestWriteDate; // 고객 문의사항 게시일
	private Timestamp requestReplyDate; // 담당자 답변사항 게시일
	private int requestReply; // 답변여부 확인 0(답변안함) 1(답변함) 
	 */
	
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
	private int requestReply;
	
	
	/*---------------------- 1:1문의 DTO 시작 ----------------------*/ 

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

	public String getRequestReplyContent() {
		return requestReplyContent;
	}

	public void setRequestReplyContent(String requestReplyContent) {
		this.requestReplyContent = requestReplyContent;
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

	public int getRequestReply() {
		return requestReply;
	}

	public void setRequestReply(int requestReply) {
		this.requestReply = requestReply;
	}
	/*---------------------- 1:1문의 DTO 종료 ----------------------*/ 
}
