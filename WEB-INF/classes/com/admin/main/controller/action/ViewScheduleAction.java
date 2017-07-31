package com.admin.main.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MainPageDAO;
import com.admin.dto.MainPageDTO;

public class ViewScheduleAction implements MainAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/main/viewSchedule.jsp";

		String todolist = request.getParameter("todolist");
System.out.println(todolist);
		MainPageDAO dao = MainPageDAO.getInstance();

		MainPageDTO dto = dao.showChoiceTodaySchedule(todolist);
		
		request.setAttribute("viewSchedule", dto);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
