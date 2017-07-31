package com.admin.main.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.MainPageDAO;

public class UpdateMemoAction implements MainAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "./MainServlet?command=main_page";
		
		MainPageDAO dao = MainPageDAO.getInstance();
		String memoContent = request.getParameter("memoContent"); 
		
		if(dao.showMemoInfo() == null){
			dao.addAdminMemo();			
		}
		
		dao.updateMemoContent(memoContent);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
