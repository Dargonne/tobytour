package com.admin.member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MemberViewDAO;

public class MemberDeleteAction implements MemberAction {
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		// TODO Auto-generated method stub
		String seqID = request.getParameter("seq");
	
		MemberViewDAO dao = MemberViewDAO.getInstance();
		dao.updateMemberDelete(seqID);
		
		new MemberListAction().execute(request, response);

		
	}

}
