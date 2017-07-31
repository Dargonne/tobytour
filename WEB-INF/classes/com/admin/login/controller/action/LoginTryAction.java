package com.admin.login.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.LoginAdminDAO;
import com.admin.dto.LoginAdminDTO;

public class LoginTryAction implements LoginAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		LoginAdminDTO dto = new LoginAdminDTO();
		LoginAdminDAO dao = LoginAdminDAO.getInstance(); 
		

		String adminID = request.getParameter("adminID"); 
		String adminPassword = request.getParameter("adminPassword"); 

		HttpSession session = request.getSession();
		

		dto.setAdminID(adminID);
		dto.setAdminPassword(adminPassword);
		
		
		int isValidateCount = dao.validateID(dto);
		
		if(isValidateCount == 1){
			session.setAttribute("id", adminID);

			new LoginSuccessAction().execute(request, response);
		} else {
			
			new LoginFailAction().execute(request, response);
		}
		
	}

}
