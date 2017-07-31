package com.web.login.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LoginDAO;

public class SearchIdAction implements LoginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/login/searchIdFinishForm.jsp";
		String search_id="";
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String birth=request.getParameter("birth");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		LoginDAO dao = LoginDAO.getInstance();
		search_id=dao.search_id(name, phone, birth);
		
		if(search_id==""){
			out.println("<script type='text/javascript'>alert('加入した会員がありません。')");
			out.println("location.href('LoginServlet?command=searchForm')</script>"); 
		}else {
			request.setAttribute("search_id", search_id);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
