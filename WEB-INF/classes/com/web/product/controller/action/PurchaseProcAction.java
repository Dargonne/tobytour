package com.web.product.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.PurchaseDAO;
import com.web.dto.PurchaseDTO;

public class PurchaseProcAction implements ProductAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		PurchaseDAO dao = PurchaseDAO.getInstance();
		PurchaseDTO dto = new PurchaseDTO();
		String getRecentNum = dao.getPurchaseNum();
		int numRecent = 0; 
		
		if(getRecentNum != null)	{	
			numRecent = Integer.parseInt(getRecentNum.substring(2, getRecentNum.length())); 
		}
		
		numRecent++;
		
		String setRecentNum = null; 
		if(numRecent>0 && numRecent<10)
		{
			setRecentNum = "PR0000" + String.valueOf(numRecent); 
		}else if(numRecent>9 && numRecent<100){
			setRecentNum = "PR000" + String.valueOf(numRecent); 
		}else if(numRecent>99 && numRecent<1000){
			setRecentNum = "PR00" + String.valueOf(numRecent); 
		}else if(numRecent>999 && numRecent<10000){
			setRecentNum = "PR0" + String.valueOf(numRecent); 
		}else if(numRecent >= 10000){
			setRecentNum = "PR" + String.valueOf(numRecent); 
		}
		dto.setPurchaseMainSeq(request.getParameter("mainproduct_no"));		
		dto.setPurchaseSeq(setRecentNum);
		dto.setPurchaseSubSeq(request.getParameter("subproduct_no"));
		dto.setPurchaseID(request.getParameter("id"));
		dto.setPurchaseTraveler(request.getParameter("traveler"));
		dto.setPurchaseTotalCost(Integer.parseInt(request.getParameter("totalcost")));
		dto.setPurchasePaymentMeasure(Integer.parseInt(request.getParameter("paymentMeasure")));
	
		
		int travelerCount = Integer.parseInt(request.getParameter("travelerCount")); 
		String subProductNo = request.getParameter("subproduct_no"); 
		String mainProductNo = request.getParameter("mainproduct_no"); 
		
		if(dao.insertPurchaseInfo(dto)){
			dao.changeProductLeast(travelerCount, subProductNo, mainProductNo);
			dao.addSalesCost(Integer.parseInt(request.getParameter("totalcost")));
			new ProductSuccessAction().execute(request, response);
		}else {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('決済処理が失敗しましたもう一度試みしてください。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		}
		
		
	}

}
