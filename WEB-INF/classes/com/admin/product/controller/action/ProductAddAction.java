package com.admin.product.controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductDAO;
import com.admin.dto.ProductDTO;
import com.admin.product.controller.ProductActionFactory;
import com.sun.org.apache.bcel.internal.generic.InstructionTargeter;

public class ProductAddAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/product/product_add_form.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}
}
