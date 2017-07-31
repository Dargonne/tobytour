package com.admin.main.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MainPageDAO;

public class DeleteScheduleAction implements MainAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String todolist = request.getParameter("todolist"); 
		
		MainPageDAO dao = MainPageDAO .getInstance(); 
		dao.deleteSchedule(todolist);
		
		new MainPageAction().execute(request, response);		
	}

}
