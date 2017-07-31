package com.admin.dto;

import java.sql.Timestamp;;

public class AnalysisDTO {

	/*--------------------- Counter DTO 시작 ---------------------*/
	private Timestamp visitDay; 
	private int visitCount; 
	
	public Timestamp getVisitDay() {
		return visitDay;
	}
	public void setVisitDay(Timestamp visitDay) {
		this.visitDay = visitDay;
	}
	public int getVisitCount() {
		return visitCount;
	}
	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	/*--------------------- Counter DTO 종료 ---------------------*/
	
	
	
	/*--------------------- 매출 정보 DTO 시작 ---------------------*/
	
	private Timestamp salesDate; 
	private int salesDayTotal; 
	private String salesPurchaseSeq; 
	private String salesProductNo; 
	private String salesID; 
	private int salesTotalCost; 
	private int salesPaymentMeasure; 
	private Timestamp salesPaymentDay; 
	private int salesCancelStatus;

	public Timestamp getSalesDate() {
		return salesDate;
	}
	
	public void setSalesDate(Timestamp salesDate) {
		this.salesDate = salesDate;
	}
	
	public int getSalesDayTotal() {
		return salesDayTotal;
	}
	
	public void setSalesDayTotal(int salesDayTotal) {
		this.salesDayTotal = salesDayTotal;
	}
	
	public String getSalesPurchaseSeq() {
		return salesPurchaseSeq;
	}
	
	public void setSalesPurchaseSeq(String salesPurchaseSeq) {
		this.salesPurchaseSeq = salesPurchaseSeq;
	}
	
	public String getSalesProductNo() {
		return salesProductNo;
	}
	
	public void setSalesProductNo(String salesProductNo) {
		this.salesProductNo = salesProductNo;
	}
	
	public String getSalesID() {
		return salesID;
	}
	
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	
	public int getSalesTotalCost() {
		return salesTotalCost;
	}
	
	public void setSalesTotalCost(int salesTotalCost) {
		this.salesTotalCost = salesTotalCost;
	}
	
	public int getSalesPaymentMeasure() {
		return salesPaymentMeasure;
	}
	
	public void setSalesPaymentMeasure(int salesPaymentMeasure) {
		this.salesPaymentMeasure = salesPaymentMeasure;
	}
	
	public Timestamp getSalesPaymentDay() {
		return salesPaymentDay;
	}
	
	public void setSalesPaymentDay(Timestamp salesPaymentDay) {
		this.salesPaymentDay = salesPaymentDay;
	}
	
	public int getSalesCancelStatus() {
		return salesCancelStatus;
	}
	
	public void setSalesCancelStatus(int salesCancelStatus) {
		this.salesCancelStatus = salesCancelStatus;
	}
	
	/*--------------------- 매출 정보 DTO 종료 ---------------------*/
}
