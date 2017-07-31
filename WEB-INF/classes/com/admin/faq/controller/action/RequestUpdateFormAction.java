package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqRequestDAO;
import com.admin.dto.FaqRequestDTO;

// 게시글 수정하는 화면으로 이동시키는 액션 클래스 
public class RequestUpdateFormAction implements RequestAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/faq/request_update.jsp"; 
		
		String seqNumber = request.getParameter("seq"); 
		
		FaqRequestDAO dao = FaqRequestDAO.getInstance();
		
		// 글번호에 해당하는 내용을 상세보기
		FaqRequestDTO dto = dao.showChoiceRequestArticle(seqNumber);
		request.setAttribute("requestUpdate", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
