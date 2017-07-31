package com.web.register.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.RegisterDAO;
import com.web.dto.RegisterDTO;

public class RegisterAddAction implements RegisterAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		request.setCharacterEncoding("utf-8");
		
		RegisterDAO dao = RegisterDAO.getInstance();
		RegisterDTO dto = new RegisterDTO();

		int userSex = Integer.parseInt(request.getParameter("userSex"));
		int userEmail = Integer.parseInt(request.getParameter("userEmail"));
		
		dto.setUserID(request.getParameter("userID"));
		dto.setUserPassword(request.getParameter("userPassword1"));
		dto.setUserAddress(request.getParameter("userAddress"));
		dto.setUserName(request.getParameter("userName"));
		dto.setUserBirth(request.getParameter("userBirth"));
		dto.setUserSex(userSex);
		dto.setUserBirth(request.getParameter("userBirth"));
		dto.setUserPhone(request.getParameter("userPhone"));
		dto.setUserEmailReceive(userEmail);
		
		dao.insertMember(dto);
		dao.addJoinMemberCount();
		
		request.setAttribute("id", request.getParameter("userID"));
		request.setAttribute("name", request.getParameter("userName"));
		
		new RegisterCompleteAction().execute(request, response);
		
	}

}
