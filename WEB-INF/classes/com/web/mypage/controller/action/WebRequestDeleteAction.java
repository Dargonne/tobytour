package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.WebRequestDAO;

public class WebRequestDeleteAction implements WebRequestAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String seqNumber = request.getParameter("seq"); 
		
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
		
		WebRequestDAO dao = WebRequestDAO.getInstance();
		dao.deleteRequestArticle(seqNumber, userID);
		
		
		new WebRequestListAction().execute(request, response);		
		
	}

}
