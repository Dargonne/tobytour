package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.MemberOutDAO;

public class MemberOutProcAction implements MemberOutAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
	     
		String password = request.getParameter("password"); 
		
		MemberOutDAO dao = MemberOutDAO.getInstance();
		
		if(dao.checkID(id, password))
		{
			dao.deleteMember(id, password);
			new MemberOutCompleteAction().execute(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('ﾊﾟｽﾜ-ﾄﾞが正しくないために会員脱退を進めることができません。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
			
			out.close();	
		}	
	}

}
