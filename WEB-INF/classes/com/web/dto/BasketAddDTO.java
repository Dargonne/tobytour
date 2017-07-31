package com.web.dto;

public class BasketAddDTO {
	private String basketSeq; 
	private String basketMainSeq; 
	private String basketSubSeq; 
	private int basketCredit; 
	private String basketID;
	
	public String getBasketSeq() {
		return basketSeq;
	}
	
	public void setBasketSeq(String basketSeq) {
		this.basketSeq = basketSeq;
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
	
	public int getBasketCredit() {
		return basketCredit;
	}
	
	public void setBasketCredit(int basketCredit) {
		this.basketCredit = basketCredit;
	}
	
	public String getBasketID() {
		return basketID;
	}
	
	public void setBasketID(String basketID) {
		this.basketID = basketID;
	} 
}
