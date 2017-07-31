package com.admin.dto;

import java.sql.Timestamp;

public class OrderListDTO {
	/*--------------------- 주문관리 DTO 시작 ---------------------*/

	private String orderListSeq; 
	private String orderListSubProductNo;
	private String orderListID; 
	private Timestamp orderDay; 
	private int orderListTotalCost; 
	private int orderListPaymentMeasure; 
	private int orderListPaymentStatus;
	private int orderListCancelStatus;
	
	
	
	public int getOrderListPaymentStatus() {
		return orderListPaymentStatus;
	}

	public void setOrderListPaymentStatus(int orderListPaymentStatus) {
		this.orderListPaymentStatus = orderListPaymentStatus;
	}

	public Timestamp getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Timestamp orderDay) {
		this.orderDay = orderDay;
	}

	public String getOrderListSeq() {
		return orderListSeq;
	}
	
	public void setOrderListSeq(String orderListSeq) {
		this.orderListSeq = orderListSeq;
	}
	
	public String getOrderListSubProductNo() {
		return orderListSubProductNo;
	}
	
	public void setOrderListSubProductNo(String orderListSubProductNo) {
		this.orderListSubProductNo = orderListSubProductNo;
	}
	
	public String getOrderListID() {
		return orderListID;
	}
	
	public void setOrderListID(String orderListID) {
		this.orderListID = orderListID;
	}
	
	public int getOrderListTotalCost() {
		return orderListTotalCost;
	}
	
	public void setOrderListTotalCost(int orderListTotalCost) {
		this.orderListTotalCost = orderListTotalCost;
	}
	
	public int getOrderListPaymentMeasure() {
		return orderListPaymentMeasure;
	}
	
	public void setOrderListPaymentMeasure(int orderListPaymentMeasure) {
		this.orderListPaymentMeasure = orderListPaymentMeasure;
	}
	
	public int getOrderListCancelStatus() {
		return orderListCancelStatus;
	}
	
	public void setOrderListCancelStatus(int orderListCancelStatus) {
		this.orderListCancelStatus = orderListCancelStatus;
	} 
	
}
