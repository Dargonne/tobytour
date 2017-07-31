package com.admin.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class ProductSubViewDTO {
	
	private String subProductNo; 
	private String mainProductNo; 
	private Timestamp subStartDay; 
	private Timestamp subEndDay; 
	private String subAirLine; 
	private int subCost; 
	private int subOilCost; 
	private Timestamp subDueDate; 
	private int subSellStatus; 
	private int subProductList;
	
	public String getSubProductNo() {
		return subProductNo;
	}
	
	public void setSubProductNo(String subProductNo) {
		this.subProductNo = subProductNo;
	}
	
	public String getMainProductNo() {
		return mainProductNo;
	}
	
	public void setMainProductNo(String mainProductNo) {
		this.mainProductNo = mainProductNo;
	}
	
	public Timestamp getSubStartDay() {
		return subStartDay;
	}
	
	public void setSubStartDay(Timestamp subStartDay) {
		this.subStartDay = subStartDay;
	}
	
	public Timestamp getSubEndDay() {
		return subEndDay;
	}

	public void setSubEndDay(Timestamp subEndDay) {
		this.subEndDay = subEndDay;
	}

	public String getSubAirLine() {
		return subAirLine;
	}
	
	public void setSubAirLine(String subAirLine) {
		this.subAirLine = subAirLine;
	}
	
	public int getSubCost() {
		return subCost;
	}
	
	public void setSubCost(int subCost) {
		this.subCost = subCost;
	}
	
	public int getSubOilCost() {
		return subOilCost;
	}
	
	public void setSubOilCost(int subOilCost) {
		this.subOilCost = subOilCost;
	}
	
	public Timestamp getSubDueDate() {
		return subDueDate;
	}
	
	public void setSubDueDate(Timestamp subDueDate) {
		this.subDueDate = subDueDate;
	}
	
	public int getSubSellStatus() {
		return subSellStatus;
	}
	
	public void setSubSellStatus(int subSellStatus) {
		this.subSellStatus = subSellStatus;
	}
	
	public int getSubProductList() {
		return subProductList;
	}
	
	public void setSubProductList(int subProductList) {
		this.subProductList = subProductList;
	} 
	
}
