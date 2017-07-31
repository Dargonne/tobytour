package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.WebRequestDAO;
import com.web.dto.WebRequestDTO;

// 답변글을 작성한다. 
public class WebRequestWriteAction implements WebRequestAction {
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
		
		WebRequestDAO dao = WebRequestDAO.getInstance();
		String getRecentNum = dao.getRecentAricleNum(); 
		
		int numRecent = 0; 
		
		if(getRecentNum == null){
			numRecent = 0;
		} else {
			numRecent = Integer.parseInt(getRecentNum.substring(2, getRecentNum.length()));  
		}
		
		numRecent++;
		
		String setRecentNum = null; 
		
		if(numRecent>0 && numRecent<10)
		{
			setRecentNum = "RQ0000" + String.valueOf(numRecent); 
		}else if(numRecent>9 && numRecent<100){
			setRecentNum = "RQ000" + String.valueOf(numRecent); 
		}else if(numRecent>99 && numRecent<1000){
			setRecentNum = "RQ00" + String.valueOf(numRecent); 
		}else if(numRecent>999 && numRecent<10000){
			setRecentNum = "RQ0" + String.valueOf(numRecent); 
		}else if(numRecent >= 10000){
			setRecentNum = "RQ" + String.valueOf(numRecent); 
		}
		
		WebRequestDTO dto = new WebRequestDTO(); 
		dto.setRequestSeq(setRecentNum);
		dto.setRequestSection(request.getParameter("requestSection"));
		dto.setRequestUserName(request.getParameter("name"));
		dto.setRequestMail(request.getParameter("email"));
		dto.setRequestID(id);
		dto.setRequestPhone(request.getParameter("phone"));
		dto.setRequestTitle(request.getParameter("title"));
		dto.setRequestContent(request.getParameter("content"));
		
		dao.insertRequest(dto);
		
		new WebRequestListAction().execute(request, response);
		
	}
}
