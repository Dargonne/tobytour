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

public class DeleteBasketAction implements MypageAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String url = "./MainServlet?command=mypage_form";
        
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
        String seq_basket;
        
        seq_basket=request.getParameter("seq_basket");
        MypageDAO dao = MypageDAO.getInstance();
        dao.deleteBasket(id, seq_basket);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
