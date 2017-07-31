package com.admin.member.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MemberViewDAO;
import com.admin.dto.MemberViewDTO;


// 게시글 수정하는 화면으로 이동시키는 액션 클래스 
public class MemberViewAction implements MemberAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/member/member_view.jsp"; 
		
		String seqID = request.getParameter("seq"); 
		
		MemberViewDAO dao = MemberViewDAO.getInstance();
		
		// 글번호에 해당하는 내용을 상세보기
		MemberViewDTO dto = dao.showChoiceMemberView(seqID);
		
				
		request.setAttribute("memberView", dto);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
