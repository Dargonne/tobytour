package com.admin.product.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductSubViewDAO;

public class ProductSubChangeAction implements ProductAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
				
		String seqID = request.getParameter("subseq");
		
		ProductSubViewDAO dao = ProductSubViewDAO.getInstance();
		dao.showSubProductChange(seqID);
				
		new ProductMainViewAction().execute(request, response);				
		
	}

}
