package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;
import com.admin.dto.FaqDTO;

//화면수정을 통해 입력된 내용을 데이터베이스의 테이블을 수정하도록 구현한다. 
public class NoticeUpdateAction implements NoticeAction {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		FaqDTO dto = new FaqDTO(); 
			
		dto.setNoticeSeq(request.getParameter("seq"));
		dto.setNoticeTitle(request.getParameter("title"));
		dto.setNoticeContent(request.getParameter("content"));
				
		FaqDAO dao = FaqDAO.getInstance();
		dao.updateNoticeArticle(dto);
		
		new NoticeListAction().execute(request, response);		
	}
}
