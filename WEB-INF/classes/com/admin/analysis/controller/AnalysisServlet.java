package com.admin.analysis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.analysis.controller.action.AnalysisAction;


@WebServlet("/admin/analysis/AnalysisServlet")
public class AnalysisServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public AnalysisServlet(){ super(); }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command"); 
		
		AnalysisActionFactory af = AnalysisActionFactory.getInstance();
		AnalysisAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
