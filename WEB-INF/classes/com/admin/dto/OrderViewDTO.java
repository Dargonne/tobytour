package com.admin.dto;

import java.sql.Timestamp;

public class OrderViewDTO {
	private String viewPurchaseSeq; 
	private String viewPurchaseProductCode;
	private String viewPurchaseID; 
	private String viewPurchaseTraveler; 
	private int viewPurchaseTotalCost; 
	private int viewPurchasePaymentMeasure; 
	private int viewPurchasePaymentResult; 
	private Timestamp viewPurchasePaymentDate; 
	private int viewPurchaseCancelStatus;
	
	public String getViewPurchaseSeq() {
		return viewPurchaseSeq;
	}
	
	public void setViewPurchaseSeq(String viewPurchaseSeq) {
		this.viewPurchaseSeq = viewPurchaseSeq;
	}
	
	public String getViewPurchaseProductCode() {
		return viewPurchaseProductCode;
	}
	
	public void setViewPurchaseProductCode(String viewPurchaseProductCode) {
		this.viewPurchaseProductCode = viewPurchaseProductCode;
	}
	
	public String getViewPurchaseID() {
		return viewPurchaseID;
	}
	
	public void setViewPurchaseID(String viewPurchaseID) {
		this.viewPurchaseID = viewPurchaseID;
	}
	
	public String getViewPurchaseTraveler() {
		return viewPurchaseTraveler;
	}
	
	public void setViewPurchaseTraveler(String viewPurchaseTraveler) {
		this.viewPurchaseTraveler = viewPurchaseTraveler;
	}
	
	public int getViewPurchaseTotalCost() {
		return viewPurchaseTotalCost;
	}
	
	public void setViewPurchaseTotalCost(int viewPurchaseTotalCost) {
		this.viewPurchaseTotalCost = viewPurchaseTotalCost;
	}
	
	public int getViewPurchasePaymentMeasure() {
		return viewPurchasePaymentMeasure;
	}
	
	public void setViewPurchasePaymentMeasure(int viewPurchasePaymentMeasure) {
		this.viewPurchasePaymentMeasure = viewPurchasePaymentMeasure;
	}
	
	public int getViewPurchasePaymentResult() {
		return viewPurchasePaymentResult;
	}
	
	public void setViewPurchasePaymentResult(int viewPurchasePaymentResult) {
		this.viewPurchasePaymentResult = viewPurchasePaymentResult;
	}
	
	public Timestamp getViewPurchasePaymentDate() {
		return viewPurchasePaymentDate;
	}
	
	public void setViewPurchasePaymentDate(Timestamp viewPurchasePaymentDate) {
		this.viewPurchasePaymentDate = viewPurchasePaymentDate;
	}
	
	public int getViewPurchaseCancelStatus() {
		return viewPurchaseCancelStatus;
	}
	
	public void setViewPurchaseCancelStatus(int viewPurchaseCancelStatus) {
		this.viewPurchaseCancelStatus = viewPurchaseCancelStatus;
	} 
	
}
