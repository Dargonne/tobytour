package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MemberOutCheckFormAction implements MemberOutAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/mypage/member_out_form.jsp"; 
		 
		HttpSession session = request.getSession();
	     String id= (String) session.getAttribute("id"); 
	        
	        if(id == null){
	        	
	        	response.setContentType("text/html; charset=utf-8"); 
	        	PrintWriter out = response.getWriter();
				
				out.println("<html><head>");
				out.println("<script>");
				out.println(" alert('ﾛｸﾞｲﾝした状態ではありません。 ﾛｸﾞｲﾝしてください。');");
				out.println(" history.back();"); 
				out.println("</script></head><body></body></html>"); 
				
				out.close();	
	        }
		
		
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
