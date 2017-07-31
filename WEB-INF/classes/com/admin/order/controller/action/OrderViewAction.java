package com.admin.order.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.OrderViewDAO;
import com.admin.dto.OrderViewDTO;


// 게시글 수정하는 화면으로 이동시키는 액션 클래스 
public class OrderViewAction implements OrderAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/order/order_view.jsp"; 
		
		String seqNumber = request.getParameter("seq"); 
		
		OrderViewDAO dao = OrderViewDAO.getInstance();
		
		// 글번호에 해당하는 내용을 상세보기
		OrderViewDTO dto = dao.showAllPurchaseView(seqNumber);
		
		String[] travelerName = dto.getViewPurchaseTraveler().trim().split("/");
		String traveler = String.valueOf(travelerName.length);
		
		request.setAttribute("orderView", dto);
		request.setAttribute("traveler", traveler);		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
