package com.admin.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.member.controller.action.MemberAction;


@WebServlet("/admin/member/MemberServlet")
public class MemberServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public MemberServlet(){ super(); }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); 
		String seq = request.getParameter("seq"); 
		request.setAttribute("seq", seq);
		
		MemberActionFactory af = MemberActionFactory.getInstance();
		MemberAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
