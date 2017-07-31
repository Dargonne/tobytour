package com.admin.product.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.dao.ProductDAO;
import com.admin.dto.ProductDTO;

public class ProductAddFinish extends HttpServlet implements ProductAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session=request.getSession();
		ProductDTO dto = new ProductDTO();
		ProductDAO dao = ProductDAO.getInstance();
		List<ProductDTO> productAddlist = new ArrayList<ProductDTO>();

		String url = "/admin/product/finish_form.jsp";

		// 상품 번호 구하기
		String locateCategory = request.getParameter("Step1");
		String mainProduct_no = dao.getProductAricleNum(locateCategory);

		int productNumRecent = 0;
		String productSetRecentNum = null;
		
		
		if (mainProduct_no== null) {
			productNumRecent = 0;
		} else {
			productNumRecent = Integer.parseInt(mainProduct_no.substring(2, mainProduct_no.length()));
		}
		productNumRecent++;

		if (productNumRecent > 0 && productNumRecent < 10)
		{
			if (locateCategory.equals("일본")) {
				productSetRecentNum = "JP0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("미국")) {
				productSetRecentNum = "USA0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("호주")) {
				productSetRecentNum = "AU0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("서울")) {
				productSetRecentNum = "SEO0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("부산")) {
				productSetRecentNum = "BU0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("인천")) {
				productSetRecentNum = "INC0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대구")) {
				productSetRecentNum = "DGU0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대전")) {
				productSetRecentNum = "DJE0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("광주")) {
				productSetRecentNum = "GWJ0000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("제주")) {
				productSetRecentNum = "JE0000" + String.valueOf(productNumRecent);
			}
			
		} else if (productNumRecent > 9 && productNumRecent < 100) {
			if (locateCategory.equals("일본")) {
				productSetRecentNum = "JP000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("미국")) {
				productSetRecentNum = "USA000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("호주")) {
				productSetRecentNum = "AU000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("서울")) {
				productSetRecentNum = "SEO000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("부산")) {
				productSetRecentNum = "BU000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("인천")) {
				productSetRecentNum = "INC000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대구")) {
				productSetRecentNum = "DGU000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대전")) {
				productSetRecentNum = "DJE000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("광주")) {
				productSetRecentNum = "GWJ000" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("제주")) {
				productSetRecentNum = "JE000" + String.valueOf(productNumRecent);
			}
		} else if (productNumRecent > 99 && productNumRecent < 1000) {
			if (locateCategory.equals("일본")) {
				productSetRecentNum = "JP00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("미국")) {
				productSetRecentNum = "USA00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("호주")) {
				productSetRecentNum = "AU00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("서울")) {
				productSetRecentNum = "SEO00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("부산")) {
				productSetRecentNum = "BU00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("인천")) {
				productSetRecentNum = "INC00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대구")) {
				productSetRecentNum = "DGU00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대전")) {
				productSetRecentNum = "DJE00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("광주")) {
				productSetRecentNum = "GWJ00" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("제주")) {
				productSetRecentNum = "JE00" + String.valueOf(productNumRecent);
			}
		} else if (productNumRecent > 999 && productNumRecent < 10000) {
			if (locateCategory.equals("일본")) {
				productSetRecentNum = "JP0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("미국")) {
				productSetRecentNum = "USA0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("호주")) {
				productSetRecentNum = "AU0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("서울")) {
				productSetRecentNum = "SEO0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("부산")) {
				productSetRecentNum = "BU0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("인천")) {
				productSetRecentNum = "INC0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대구")) {
				productSetRecentNum = "DGU0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대전")) {
				productSetRecentNum = "DJE0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("광주")) {
				productSetRecentNum = "GWJ0" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("제주")) {
				productSetRecentNum = "JE0" + String.valueOf(productNumRecent);
			}
		} else if (productNumRecent >= 10000) {
			if (locateCategory.equals("일본")) {
				productSetRecentNum = "JP" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("미국")) {
				productSetRecentNum = "USA" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("호주")) {
				productSetRecentNum = "AU" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("서울")) {
				productSetRecentNum = "SEO" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("부산")) {
				productSetRecentNum = "BU" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("인천")) {
				productSetRecentNum = "INC" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대구")) {
				productSetRecentNum = "DGU" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("대전")) {
				productSetRecentNum = "DJE" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("광주")) {
				productSetRecentNum = "GWJ" + String.valueOf(productNumRecent);
			} else if (locateCategory.equals("제주")) {
				productSetRecentNum = "JE" + String.valueOf(productNumRecent);
			}
		}

		// 값들을 list에 담기

		dto.setMainproduct_no(productSetRecentNum);
		dto.setLocatecategory(locateCategory);
		dto.setProductname(request.getParameter("productname"));
		dto.setProductstatement(request.getParameter("productstatement"));
		String[] depDayList = request.getParameterValues("depday");
		String depDay = "";
		for (int i = 0; i < depDayList.length; i++) {
			depDay += depDayList[i] + "/";
		}
		dto.setDepday(depDay);
		dto.setProductimage((String)session.getAttribute("productImage"));
		dto.setIncludelist(request.getParameter("includelist"));
		dto.setExcludelist(request.getParameter("excludelist"));
		dto.setChoicecost(request.getParameter("choicecost"));
		dto.setRecommendcomment(request.getParameter("recommendcomment"));
		System.out.println((String)session.getAttribute("productImage"));
		dto.setDay1(request.getParameter("day1"));
		dto.setDay2(request.getParameter("day2"));
		dto.setDay3(request.getParameter("day3"));
		dto.setDay4(request.getParameter("day4"));
		dto.setDay5(request.getParameter("day5"));
		
		dto.setHotelname(request.getParameter("hotelname"));
		dto.setHotelimage((String)session.getAttribute("hotelImage"));
		dto.setHotelinfo(request.getParameter("hotelinfo"));
		
		dto.setCaution(request.getParameter("caution"));
		dto.setInsurunce(request.getParameter("insurunce"));
		dto.setAgreement(request.getParameter("agreement"));
		dto.setSafeinfo(request.getParameter("safeinfo"));
		dto.setHelpphone(request.getParameter("helpphone"));

		productAddlist.add(dto);

		// 데이터베이스에 입력

		dao.insertProduct(dto);

		request.setAttribute("productAddlist", productAddlist);

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		System.out.println(productAddlist.size());
	}
}
