package com.web.dto;

import java.sql.Timestamp;

public class MypageDTO {
	
	//SUBPRODUCTINFO 테이블
	private String mainproduct_no;
	private String subproduct_no;
	private Timestamp startday;
	private Timestamp endday;
	
	//PURCHASEINFO 테이블
	private String seq_purchase;
	private String traveler;
	private int totalcost;
	private Timestamp paymentday;
	private int cancelstatus;
	
	//BASKETINFO 테이블
	private String seq_basket;
	private String basketMainSeq; 
	private String basketSubSeq; 
	
	//MAINPRODCUTINFO 테이블
	private String productname;
	
	public String getMainproduct_no() {
		return mainproduct_no;
	}
	public void setMainproduct_no(String mainproduct_no) {
		this.mainproduct_no = mainproduct_no;
	}
	public String getSeq_purchase() {
		return seq_purchase;
	}
	public void setSeq_purchase(String seq_purchase) {
		this.seq_purchase = seq_purchase;
	}
	public String getSeq_basket() {
		return seq_basket;
	}
	public void setSeq_basket(String seq_basket) {
		this.seq_basket = seq_basket;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getCancelstatus() {
		return cancelstatus;
	}
	public void setCancelstatus(int cancelstatus) {
		this.cancelstatus = cancelstatus;
	}
	public String getSubproduct_no() {
		return subproduct_no;
	}
	public void setSubproduct_no(String subproduct_no) {
		this.subproduct_no = subproduct_no;
	}
	public Timestamp getStartday() {
		return startday;
	}
	public void setStartday(Timestamp startday) {
		this.startday = startday;
	}
	public Timestamp getEndday() {
		return endday;
	}
	public void setEndday(Timestamp endday) {
		this.endday = endday;
	}
	public String getTraveler() {
		return traveler;
	}
	public void setTraveler(String traveler) {
		this.traveler = traveler;
	}
	public int getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(int totalcost) {
		this.totalcost = totalcost;
	}
	public Timestamp getPaymentday() {
		return paymentday;
	}
	public void setPaymentday(Timestamp paymentday) {
		this.paymentday = paymentday;
	}
	public String getBasketMainSeq() {
		return basketMainSeq;
	}
	public void setBasketMainSeq(String basketMainSeq) {
		this.basketMainSeq = basketMainSeq;
	}
	public String getBasketSubSeq() {
		return basketSubSeq;
	}
	public void setBasketSubSeq(String basketSubSeq) {
		this.basketSubSeq = basketSubSeq;
	}
	
}
