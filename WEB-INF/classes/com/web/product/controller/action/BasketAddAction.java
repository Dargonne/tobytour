package com.web.product.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.BasketAddDAO;
import com.web.dto.BasketAddDTO;

public class BasketAddAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
	        
		String mainProductNo = request.getParameter("mainproduct_no"); 
		String subProductNo = request.getParameter("subproduct_no"); 
		
		BasketAddDAO dao = BasketAddDAO.getInstance();
		BasketAddDTO dto = new BasketAddDTO(); 
		
		String getRecentNum = dao.getRecentBasketNum();
		String setRecentNum = null; 
		
		int numRecent = 0; 
		if(getRecentNum == null)
		{
			setRecentNum = "BA00001";
			
		}else {
			numRecent = Integer.parseInt(getRecentNum.substring(2, getRecentNum.length()));  
			numRecent++;
			
			
			if(numRecent>0 && numRecent<10)
			{
				setRecentNum = "BA0000" + String.valueOf(numRecent); 
			}else if(numRecent>9 && numRecent<100){
				setRecentNum = "BA000" + String.valueOf(numRecent); 
			}else if(numRecent>99 && numRecent<1000){
				setRecentNum = "BA00" + String.valueOf(numRecent); 
			}else if(numRecent>999 && numRecent<10000){
				setRecentNum = "BA0" + String.valueOf(numRecent); 
			}else if(numRecent >= 10000){
				setRecentNum = "BA" + String.valueOf(numRecent); 
			}
		}
		
		
		dto.setBasketID(userID);
		dto.setBasketMainSeq(mainProductNo);
		dto.setBasketSubSeq(subProductNo);
		dto.setBasketSeq(setRecentNum);
		
		if(dao.insertBasket(dto)){
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('選択した製品が買い物籠に盛り込まれました。 ');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		} else {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('買い物籠に盛り込まれていませんもう一度試みて下さい。 ');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		}
				
		
		
		
	}

}
