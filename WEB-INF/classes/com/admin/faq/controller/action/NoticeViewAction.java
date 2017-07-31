package com.admin.faq.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;
import com.admin.dto.FaqDTO;

public class NoticeViewAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/faq/notice_view.jsp"; 
		
		String seqNumber = request.getParameter("seq"); 
		
		FaqDAO dao = FaqDAO.getInstance();
		
		// 글번호에 해당하는 내용을 상세보기
		FaqDTO dto = dao.showChoiceNoticeArticle(seqNumber);
		
		request.setAttribute("noticeArticle", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
