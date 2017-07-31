package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.WebRequestDAO;
import com.web.dto.WebRequestDTO;

public class WebRequestViewAction implements WebRequestAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/mypage/request_view.jsp"; 
		
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
		
		// 글번호에 해당하는 내용을 상세보기
		WebRequestDTO dto = dao.showChoiceRequestArticle(userID, seqNumber);
		
		request.setAttribute("request", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
