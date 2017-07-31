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


public class MainPageAction implements MainAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "/admin/main/main.jsp";
        
        String memoContent = null; 
		
		MainPageDAO dao = MainPageDAO.getInstance();
		
		
		int getMember = dao.getMember();
		int getOrder = dao.getOrder();
		int getVisitor = dao.getVisitor();
		int getSales = dao.getSales();
		
		List<MainPageDTO> noticeList = new ArrayList<MainPageDTO>(); 
		List<MainPageDTO> requestList = new ArrayList<MainPageDTO>();
		List<MainPageDTO> scheduleList = new ArrayList<MainPageDTO>();
		noticeList=dao.showNoticeArticle();
		requestList=dao.requestNoticeArticle();
		scheduleList=dao.showTodaySchedule();
		memoContent=dao.showMemoInfo();
		
		request.setAttribute("getMember", getMember);
		request.setAttribute("getOrder", getOrder);
		request.setAttribute("getVisitor", getVisitor);
		request.setAttribute("getSales", getSales);
		request.setAttribute("memoContent", memoContent);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("requestList", requestList);
		request.setAttribute("scheduleList", scheduleList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
