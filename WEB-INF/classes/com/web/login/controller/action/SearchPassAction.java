package com.web.login.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.LoginDAO;

public class SearchPassAction implements LoginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/login/searchPassFinishForm.jsp";
		String search_pass = "";
		String random_pass = "";

		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String birth = request.getParameter("birth");

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		LoginDAO dao = LoginDAO.getInstance();
		search_pass = dao.search_pass(id, phone, birth);

		if (search_pass == "") {
			out.println("<script type='text/javascript'>alert('入力された情報が正確ではありません。')");
			out.println("location.href('LoginServlet?command=searchForm')</script>");
		} else {
			for (int i = 0; i < 6; i++) {
				random_pass += Integer.toString((int) (Math.random() * 10));
			}
			System.out.println(random_pass);
			
			random_pass = dao.update_pass(id, random_pass);

			request.setAttribute("random_pass", random_pass);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

}
