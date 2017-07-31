package com.web.mypage.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.dao.MypageDAO;

public class CancelReservationAction implements MypageAction{

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
        
        String subproduct_no;
        String seq_purchase;
        String mainproduct_no;
        String traveler;
        String[] traveler_array;
        int traveler_count=0;
        
        boolean cancle_check=false;
        boolean change_check=false;
        
        seq_purchase=request.getParameter("seq_purchase");
        subproduct_no=request.getParameter("subproduct_no");
        mainproduct_no=request.getParameter("mainproduct_no");
        

        MypageDAO dao = MypageDAO.getInstance();
        
        traveler=dao.getPurchaseTraveler(id, mainproduct_no, subproduct_no, seq_purchase);
        traveler_array=traveler.split("/");
        traveler_count=traveler_array.length;
       
        cancle_check=dao.cancelReservation(id, mainproduct_no, seq_purchase);
        change_check=dao.changeProductLeast(traveler_count, subproduct_no, mainproduct_no);
        
        if(cancle_check){
            int cancelCost = dao.cancelReservationCost(id, mainproduct_no, seq_purchase);
            dao.minusSalesCost(-cancelCost);
        }
        
        if(change_check) System.out.println("");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
