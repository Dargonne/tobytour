package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;

public class NoticeDeleteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String seqNumber = request.getParameter("seq"); 
		
		FaqDAO dao = FaqDAO.getInstance(); 
		dao.deleteNoticeArticle(seqNumber);
		
		new NoticeListAction().execute(request, response);		
	}

}
