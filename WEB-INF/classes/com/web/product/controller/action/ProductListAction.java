package com.web.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.ProductDAO;
import com.web.dto.ProductDTO;


public class ProductListAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url ="/web/product/product_list.jsp";
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductDTO> productList =dao.selectAllProduction();

		String filePath = "../../temp/img/product/";
		
		request.setAttribute("filePath", filePath);
		request.setAttribute("productList", productList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
