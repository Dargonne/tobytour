package com.admin.order.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.OrderViewDAO;
import com.admin.dto.OrderViewDTO;


// 입금확인을 변경하는 항목 
public class OrderPaymentChangeAction implements OrderAction {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		String seqNum = request.getParameter("seq");
		
		OrderViewDAO dao = OrderViewDAO.getInstance();
		dao.updateChangePayment(seqNum);
		
		new OrderViewAction().execute(request, response);		
	}
}

