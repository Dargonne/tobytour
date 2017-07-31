package com.web.dto;

import java.sql.Timestamp;

public class WebNoticeDTO {
	private String noticeSeq; 
	private String noticeTitle;
	private String noticeContent; 
	private Timestamp noticeDate; 
	private int noticeCount;
	
	public String getNoticeSeq() {
		return noticeSeq;
	}
	
	public void setNoticeSeq(String noticeSeq) {
		this.noticeSeq = noticeSeq;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}
	
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	public Timestamp getNoticeDate() {
		return noticeDate;
	}
	
	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	public int getNoticeCount() {
		return noticeCount;
	}
	
	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	} 

}
