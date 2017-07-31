package com.web.main.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.WebMainPageDAO;
import com.web.dto.WebMainPageDTO;

public class WebMainViewAction implements WebMainAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/main/main.jsp"; 
		
		WebMainPageDAO dao = WebMainPageDAO.getInstance();
		dao.setGuestCounter();
		List<WebMainPageDTO> newProductList = new ArrayList<>();
				
		newProductList = dao.getRecentProduct();
		
		
		String productListFilePath ="../../temp/img/product/"; 
		
		request.setAttribute("productList", newProductList);
		request.setAttribute("productListFilePath", productListFilePath);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
