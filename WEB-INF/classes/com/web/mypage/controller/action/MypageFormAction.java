package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.MypageDAO;
import com.web.dto.MypageDTO;

public class MypageFormAction implements MypageAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "/web/mypage/mypageForm.jsp";
        
	    HttpSession session = request.getSession();
	    String id= (String) session.getAttribute("id"); 
	        
	    if(id == null){
	        	
	      	response.setContentType("text/html; charset=utf-8"); 
	       	PrintWriter out = response.getWriter();
				
			out.println("<html><head>");
			out.println("<script>");
			out.println(" alert('ﾛｸﾞｲﾝした状態ではありません。 ﾛｸﾞｲﾝしてください。');");
			out.println(" history.back();"); 
			out.println("</script></head><body></body></html>"); 
				
			out.close();	
	     } 
        
        MypageDAO dao = MypageDAO.getInstance();
		List<MypageDTO> reservationList = new ArrayList<MypageDTO>();
		List<MypageDTO> basketList = new ArrayList<MypageDTO>();
		reservationList=dao.showReservation(id);
		basketList=dao.showBasket(id);
		
		request.setAttribute("reservationList", reservationList);
		request.setAttribute("basketList", basketList);
        
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
