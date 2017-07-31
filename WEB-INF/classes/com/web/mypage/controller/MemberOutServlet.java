package com.web.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.mypage.controller.action.MemberOutAction;
import com.web.mypage.controller.action.WebRequestAction;

@WebServlet("/web/mypage/MemberOutServlet")
public class MemberOutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public MemberOutServlet(){ super(); }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); 
		
		MemberOutActionFactory af = MemberOutActionFactory.getInstance();
		MemberOutAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
