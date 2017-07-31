package com.admin.main.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MainPageDAO;
import com.admin.dto.MainPageDTO;

public class TodayScheduleAction implements MainAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "./MainServlet?command=main_page";
		
		MainPageDAO dao = MainPageDAO.getInstance();
		List<MainPageDTO> todayScheduleList = new ArrayList<MainPageDTO>(); 
		todayScheduleList=dao.showTodaySchedule();
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
