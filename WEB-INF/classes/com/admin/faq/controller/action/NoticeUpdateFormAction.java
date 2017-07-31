package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;
import com.admin.dto.FaqDTO;

// 게시글 수정하는 화면으로 이동시키는 액션 클래스 
public class NoticeUpdateFormAction implements NoticeAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/faq/notice_update.jsp"; 
		
		String seqNumber = request.getParameter("seq");
		
		FaqDAO dao = FaqDAO.getInstance();
		FaqDTO dto = dao.showChoiceNoticeArticle(seqNumber);
		
		request.setAttribute("noticeUpdate", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
