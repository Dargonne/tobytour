package com.web.faq.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.faq.notice.controller.action.WebNoticeAction;

@WebServlet("/web/faq/notice/WebNoticeServlet")
public class WebNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); 
		WebNoticeActionFactory af = WebNoticeActionFactory.getInstance();
		WebNoticeAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
