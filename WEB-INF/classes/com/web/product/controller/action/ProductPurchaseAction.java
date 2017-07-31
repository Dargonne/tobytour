package com.web.product.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.PurchaseDAO;
import com.web.dto.PurchaseDTO;

public class ProductPurchaseAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url ="/web/product/product_purchase.jsp";
		
		String subProductNo = request.getParameter("subproduct_no"); 
		HttpSession session = request.getSession();
	    String userID= (String) session.getAttribute("id"); 
	        
	    if(userID == null){
	        	
	    	response.setContentType("text/html; charset=utf-8"); 
	        PrintWriter out = response.getWriter();
				
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('ﾛｸﾞｲﾝした状態ではありません。 ﾛｸﾞｲﾝしてください。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
				
			out.close();	
	    }
		
		PurchaseDAO dao = PurchaseDAO.getInstance();
		PurchaseDTO dtoProduct = dao.getPurchaseChoice(subProductNo);
		PurchaseDTO dtoUser = dao.getPurchaseUser(userID);
		
		request.setAttribute("choice", dtoProduct);
		request.setAttribute("user", dtoUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
