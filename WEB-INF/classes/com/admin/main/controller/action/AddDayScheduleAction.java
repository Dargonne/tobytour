package com.admin.main.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MainPageDAO;

public class AddDayScheduleAction implements MainAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String selectDay = request.getParameter("selectDay");
		String year_selectDay = selectDay.substring(6, 10);
		String month_selectDay = selectDay.substring(0, 2);
		String day_selectDay = selectDay.substring(3, 5);
		selectDay = year_selectDay + month_selectDay + day_selectDay;
		String daySchedule = request.getParameter("daySchedule");

		MainPageDAO dao = MainPageDAO.getInstance();
		int check = dao.insertSelectDaySchedule(selectDay, daySchedule);
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		if (check==1) {
			out.println("<script type='text/javascript'>alert('入力が完了しました。')");
			out.println("window.close()</script>");
		}
	}

}
