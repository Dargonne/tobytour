package com.web.faq.notice.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.WebNoticeDAO;
import com.web.dto.WebNoticeDTO;

public class WebNoticeViewAction implements WebNoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/faq/notice/notice_view.jsp"; 
		
		String seqNumber = request.getParameter("seq"); 
		
		WebNoticeDAO dao = WebNoticeDAO.getInstance();
		
		// 글번호에 해당하는 내용을 상세보기
		WebNoticeDTO dto = dao.showChoiceNoticeArticle(seqNumber);
		
		request.setAttribute("noticeArticle", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
