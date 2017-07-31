package com.admin.product.controller.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductMainViewDAO;
import com.admin.dto.ProductMainViewDTO;

public class ProductMainDeleteAction implements ProductAction{
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String seqNumber = request.getParameter("seq"); 
		System.out.println(seqNumber);
		
		ProductMainViewDAO dao = ProductMainViewDAO.getInstance();
		ProductMainViewDTO dto = dao.showMainProductInfo(seqNumber);
		
		if(dto.getMainHotelImage() != null){
			String hotelFilePath = request.getRealPath("/temp/upload/img/hotel/") + dto.getMainHotelImage();		
			File hotelFile = new File( hotelFilePath );
			hotelFile.delete();
		}
		
		if(dto.getMainProductImage() != null){
			String productFilePath = request.getRealPath("/temp/upload/img/product/") + dto.getMainProductImage();
			File productFile = new File( productFilePath );
			productFile.delete();
		}
		
		
		dao.mainProductDelete(seqNumber);
		
		new ProductListAction().execute(request, response);		
		
	} 
}
