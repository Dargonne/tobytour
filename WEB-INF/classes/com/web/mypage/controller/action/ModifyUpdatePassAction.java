package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.ModifyDAO;

public class ModifyUpdatePassAction implements MypageAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/mypage/modifyFinish.jsp";

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
	    
		String pass;
		pass = request.getParameter("pass");

		ModifyDAO dao = ModifyDAO.getInstance();
		dao.modifyUpdatePass(id, pass);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
