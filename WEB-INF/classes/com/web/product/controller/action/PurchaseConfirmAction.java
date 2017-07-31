package com.web.product.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.PurchaseDAO;
import com.web.dto.PurchaseDTO;

public class PurchaseConfirmAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String url ="/web/product/product_purchase_confirm.jsp";
		
		String checkAgreement = request.getParameter("checkAgreement");
		if(checkAgreement == null){
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('約款に同意しなかったら決済を進めることができません。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		}
		
		String productName = request.getParameter("productName"); 
		String productMainNo = request.getParameter("productMainNo"); 
		String productSubNo = request.getParameter("productSubNo"); 
		String startDay = request.getParameter("startDay"); 
		String endDay = request.getParameter("endDay"); 
		int selectCost = Integer.parseInt(request.getParameter("cost")); 
		int oilCost = Integer.parseInt(request.getParameter("oilCost")); 
		String userID = request.getParameter("id"); 
		String userName = request.getParameter("name"); 
		String userPhone = request.getParameter("phone"); 
		int travelerCount = Integer.parseInt(request.getParameter("travelerCount")); 
		
		PurchaseDAO dao = PurchaseDAO.getInstance();
		int compareProduct = dao.getPurchaseLeast(productMainNo, productSubNo);
		
		System.out.println(compareProduct);
		
		if((compareProduct - travelerCount) < 0)
		{
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('数量が不足して商品を購買できません。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		} 
		
		String traveler[] = new String[4]; 
		
		for(int i=0; i<traveler.length; i++){
			traveler[i] = request.getParameter("traveler" + i);
		}
		
		String mergeTraveler = ""; 
		
		for(int j=0; j<traveler.length; j++){
			if(traveler[j] != null)
			{
				mergeTraveler += traveler[j] + "/";
			}
		}
		
		int totalCost = (selectCost + oilCost) * travelerCount; 
	
		request.setAttribute("productName", productName);
		request.setAttribute("productMainNo", productMainNo);
		request.setAttribute("productSubNo", productSubNo);
		request.setAttribute("startDay", startDay);
		request.setAttribute("endDay", endDay);
		request.setAttribute("selectCost", selectCost);
		request.setAttribute("oilCost", oilCost);
		request.setAttribute("userID", userID);
		request.setAttribute("userName", userName);
		request.setAttribute("userPhone", userPhone);
		request.setAttribute("travelerCount", travelerCount);
		request.setAttribute("traveler", mergeTraveler);
		request.setAttribute("totalCost", totalCost);	
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
