package com.web.product.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.dao.ProductDAO;
import com.web.dto.ProductDTO;


public class ProductListViewAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/product/product_view.jsp";

		String mainproduct_no = request.getParameter("mainproduct_no");
		request.setAttribute("mainproduct_no", mainproduct_no);
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO dto = dao.selectOneProduction(mainproduct_no);

		String productFilePath = "../../temp/img/product/" + dto.getProductimage();
		String hotelFilePath = "../../temp/img/hotel/" + dto.getHotelimage();
		
		request.setAttribute("productionList", dto);
		
		List<ProductDTO> SubproductionList =dao.selectSubProductInfo(mainproduct_no);
		request.setAttribute("SubproductionList", SubproductionList);
		
		request.setAttribute("hotelFilePath", hotelFilePath);
		request.setAttribute("productFilePath", productFilePath);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		
		dispatcher.forward(request, response);

		
	
		
	}

}
