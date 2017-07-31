package com.admin.product.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;
import com.admin.dao.ProductSubViewDAO;
import com.admin.faq.controller.action.NoticeListAction;

public class ProductSubDeleteAction implements ProductAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String seqNumber = request.getParameter("subseq"); 
		
		ProductSubViewDAO dao = ProductSubViewDAO.getInstance();
		dao.showSubProductDelete(seqNumber);
		
		
		new ProductMainViewAction().execute(request, response);		
	}

}
