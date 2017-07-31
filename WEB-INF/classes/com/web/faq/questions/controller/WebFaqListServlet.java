package com.web.faq.questions.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.faq.questions.controller.action.WebFaqListAction;

@WebServlet("/web/faq/often_question/WebFaqListServlet")
public class WebFaqListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); 
		WebFaqListActionFactory af = WebFaqListActionFactory.getInstance();
		WebFaqListAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
