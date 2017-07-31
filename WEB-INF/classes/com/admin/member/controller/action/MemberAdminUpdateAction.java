package com.admin.member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MemberViewDAO;

public class MemberAdminUpdateAction implements MemberAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String seqID = request.getParameter("seq");
			
		MemberViewDAO dao = MemberViewDAO.getInstance();
		dao.updateMemberAdmin(seqID);
				
		new MemberViewAction().execute(request, response);		
		
	}

}
