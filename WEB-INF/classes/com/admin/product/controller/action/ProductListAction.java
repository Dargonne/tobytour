package com.admin.product.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductDAO;
import com.admin.dto.ProductDTO;


public class ProductListAction implements ProductAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/product/product_list.jsp";
		
		final int PAGE_SIZE = 9;
		final int PAGE_GROUP_SIZE = 3; 
		
		String pageNum = request.getParameter("page"); 
		
		if(pageNum == null)	{
			pageNum = "1"; 
		}
		
		 int currentPage = Integer.parseInt(pageNum);
		 int startRow = (currentPage - 1) * PAGE_SIZE + 1;//한 페이지의 시작글 번호
		 int endRow = currentPage * PAGE_SIZE;//한 페이지의 마지막 글번호
		 int count = 0;
		 int number=0;
		 
		 
		
		
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductDTO> productList = new ArrayList();
		
		count = dao.getMainProductTotal(); 
		 if (count > 0) {        
			 if(endRow>count)
				 endRow = count;
			 	productList = dao.showMainProductInfo(startRow, endRow);
			 	
		 } else {
			 productList = null;
		 }
		
		 number=count-(currentPage-1)*PAGE_SIZE;
		 
		 int pageGroupCount = count/(PAGE_SIZE*PAGE_GROUP_SIZE)+( count % (PAGE_SIZE*PAGE_GROUP_SIZE) == 0 ? 0 : 1);
		
		int numPageGroup = (int) Math.ceil((double)currentPage/PAGE_GROUP_SIZE);
		
		request.setAttribute("productList", productList);
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(PAGE_SIZE));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("pageGroupSize", new Integer(PAGE_GROUP_SIZE));
		request.setAttribute("numPageGroup", new Integer(numPageGroup));
		request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
