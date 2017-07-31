package com.admin.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductMainViewDAO;
import com.admin.dao.ProductSubViewDAO;
import com.admin.dto.ProductSubViewDTO;

public class ProductSubViewFormAction implements ProductAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/product/product_sub_view.jsp"; 
		
		String seqNumber = request.getParameter("seq"); 
		
		ProductSubViewDAO dao = ProductSubViewDAO.getInstance();
		ProductSubViewDTO dto = dao.showSubProductInfo(seqNumber);
		
		request.setAttribute("subList", dto);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	
	}

}
