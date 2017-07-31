package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqRequestDAO;
import com.admin.dto.FaqRequestDTO;

// 답변글을 작성한다. 
public class RequestUpdateAction implements RequestAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FaqRequestDTO dto = new FaqRequestDTO(); 
			
		dto.setRequestSeq(request.getParameter("seq"));
		dto.setRequestReplyContent(request.getParameter("content"));
		
		FaqRequestDAO dao = FaqRequestDAO.getInstance();
		dao.updateRequestArticle(dto);
		
		new RequestListAction().execute(request, response);		
	}
}
