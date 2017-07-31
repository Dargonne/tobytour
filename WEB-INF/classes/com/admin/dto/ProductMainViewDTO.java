package com.admin.dto;

import java.sql.Timestamp;

public class ProductMainViewDTO {
	private String mainProductNo;
	private String mainProductImage; 
	private String mainProductName; 
	private String mainDepDay; 
	private String mainIncludeList; 
	private String mainExcludelist; 
	private String mainChoiceCost; 
	private String mainHotelImage;
	private String mainHotelName;
	private String mainHotelInfo; 
	private String subProductNo; 
	private Timestamp subStartDay; 
	private Timestamp subEndDay;
	private String subAirLine; 
	private int subProductLeast; 
	private int subListTotal;
	
	public String getMainProductNo() {
		return mainProductNo;
	}
	
	public void setMainProductNo(String mainProductNo) {
		this.mainProductNo = mainProductNo;
	}
	
	public String getMainProductImage() {
		return mainProductImage;
	}
	
	public void setMainProductImage(String mainProductImage) {
		this.mainProductImage = mainProductImage;
	}
	
	public String getMainProductName() {
		return mainProductName;
	}
	
	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}
	
	public String getMainDepDay() {
		return mainDepDay;
	}
	
	public void setMainDepDay(String mainDepDay) {
		this.mainDepDay = mainDepDay;
	}
	
	public String getMainIncludeList() {
		return mainIncludeList;
	}
	
	public void setMainIncludeList(String mainIncludeList) {
		this.mainIncludeList = mainIncludeList;
	}
	
	public String getMainExcludelist() {
		return mainExcludelist;
	}
	
	public void setMainExcludelist(String mainExcludelist) {
		this.mainExcludelist = mainExcludelist;
	}
	
	public String getMainChoiceCost() {
		return mainChoiceCost;
	}
	
	public void setMainChoiceCost(String mainChoiceCost) {
		this.mainChoiceCost = mainChoiceCost;
	}
	
	public String getMainHotelImage() {
		return mainHotelImage;
	}
	
	public void setMainHotelImage(String mainHotelImage) {
		this.mainHotelImage = mainHotelImage;
	}
	
	public String getMainHotelName() {
		return mainHotelName;
	}
	
	public void setMainHotelName(String mainHotelName) {
		this.mainHotelName = mainHotelName;
	}
	
	public String getMainHotelInfo() {
		return mainHotelInfo;
	}
	
	public void setMainHotelInfo(String mainHotelInfo) {
		this.mainHotelInfo = mainHotelInfo;
	}
	
	public String getSubProductNo() {
		return subProductNo;
	}
	
	public void setSubProductNo(String subProductNo) {
		this.subProductNo = subProductNo;
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
	
	public int getSubProductLeast() {
		return subProductLeast;
	}
	
	public void setSubProductLeast(int subProductLeast) {
		this.subProductLeast = subProductLeast;
	}
	
	public int getSubListTotal() {
		return subListTotal;
	}
	
	public void setSubListTotal(int subListTotal) {
		this.subListTotal = subListTotal;
	}  	
}
