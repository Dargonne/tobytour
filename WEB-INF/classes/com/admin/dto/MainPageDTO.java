package com.admin.dto;

import java.sql.Date;
import java.sql.Timestamp;

import oracle.net.aso.d;

public class MainPageDTO {
	
	private String noticeSeq; 
	private String noticeTitle; 
	private String noticeContent; 
	private Timestamp noticeWriteDate;
	
	private String requestSeq;
	private String requestTitle; 
	private Timestamp requestWriteDate;
	private int requestReply;

	private String memoContent;
	
	private Timestamp tododate; 
	private String todolist;
	
	private int getOrder;
	private int getSales;
	private int getMember;
	private int getVisitor; 
	
	
	public int getGetOrder() {
		return getOrder;
	}
	
	public void setGetOrder(int getOrder) {
		this.getOrder = getOrder;
	}
	
	public int getGetSales() {
		return getSales;
	}
	
	public void setGetSales(int getSales) {
		this.getSales = getSales;
	}
	
	public int getGetMember() {
		return getMember;
	}
	
	public void setGetMember(int getMember) {
		this.getMember = getMember;
	}
	
	public int getGetVisitor() {
		return getVisitor;
	}
	
	public void setGetVisitor(int getVisitor) {
		this.getVisitor = getVisitor;
	}
	
	public Timestamp getTododate() {
		return tododate;
	}
	
	public void setTododate(Timestamp tododate) {
		this.tododate = tododate;
	}
	
	public String getTodolist() {
		return todolist;
	}
	
	public void setTodolist(String todolist) {
		this.todolist = todolist;
	}
	
	public String getMemoContent() {
		return memoContent;
	}
	
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}
	
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
	
	public Timestamp getNoticeWriteDate() {
		return noticeWriteDate;
	}
	
	public void setNoticeWriteDate(Timestamp noticeWriteDate) {
		this.noticeWriteDate = noticeWriteDate;
	}
	
	public String getRequestSeq() {
		return requestSeq;
	}
	
	public void setRequestSeq(String requestSeq) {
		this.requestSeq = requestSeq;
	}
	
	public String getRequestTitle() {
		return requestTitle;
	}
	
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	
	public Timestamp getRequestWriteDate() {
		return requestWriteDate;
	}
	
	public void setRequestWriteDate(Timestamp requestWriteDate) {
		this.requestWriteDate = requestWriteDate;
	}
	
	public int getRequestReply() {
		return requestReply;
	}
	
	public void setRequestReply(int requestReply) {
		this.requestReply = requestReply;
	}
	
}
