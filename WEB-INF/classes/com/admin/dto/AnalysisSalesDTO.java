package com.admin.dto;

import java.sql.Timestamp;

public class AnalysisSalesDTO {
	private Timestamp paymentDay;
	private int totalCost;
	
	public Timestamp getPaymentDay() {
		return paymentDay;
	}
	
	public void setPaymentDay(Timestamp paymentDay) {
		this.paymentDay = paymentDay;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	} 
	
}
