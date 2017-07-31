package com.admin.product.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.ProductSubViewDAO;
import com.admin.dto.ProductSubInsertDTO;

public class ProductSubWriteAction implements ProductAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String mainSeq = request.getParameter("seq");
		int numRecent = 0; 
		ProductSubViewDAO dao = ProductSubViewDAO.getInstance();
		String getRecentNum = null; 
		getRecentNum = dao.getSubProductNum(mainSeq);

		if(getRecentNum == null)
		{
			numRecent = 0; 
			getRecentNum = "NO00001"; 
		} else {
			numRecent = Integer.parseInt(getRecentNum.substring(2, getRecentNum.length())); 
		}
			numRecent++;
				
				
		String setRecentNum = null; 
		if(numRecent>0 && numRecent<10)
		{
			setRecentNum = "NO0000" + String.valueOf(numRecent); 
		}else if(numRecent>9 && numRecent<100){
			setRecentNum = "NO000" + String.valueOf(numRecent); 
		}else if(numRecent>99 && numRecent<1000){
			setRecentNum = "NO00" + String.valueOf(numRecent); 
		}else if(numRecent>999 && numRecent<10000){
			setRecentNum = "NO0" + String.valueOf(numRecent); 
		}else if(numRecent >= 10000){
			setRecentNum = "NO" + String.valueOf(numRecent); 
		}
		
	
		java.sql.Date startDateParse = java.sql.Date.valueOf(request.getParameter("start_date"));
		java.sql.Date endDateParse =  java.sql.Date.valueOf(request.getParameter("end_date"));
		java.sql.Date dueDateParse =  java.sql.Date.valueOf(request.getParameter("due_date"));
			
				
		ProductSubInsertDTO dto = new ProductSubInsertDTO(); 
		dto.setSubProductNo(setRecentNum);
		dto.setMainProductNo(mainSeq);
		dto.setSubStartDay(startDateParse);
		dto.setSubEndDay(endDateParse);
		dto.setSubAirLine(request.getParameter("airline"));
		dto.setSubCost(Integer.parseInt(request.getParameter("cost")));
		dto.setSubOilCost(Integer.parseInt(request.getParameter("oilcost")));
		dto.setSubDueDate(dueDateParse);
		dto.setSubProductList(Integer.parseInt(request.getParameter("qty")));
				
				
		//DB에 추가
		if(dao.subProductInsert(dto)){
			response.setContentType("text/html; charset=utf-8");
			PrintWriter scriptOut = response.getWriter(); 
					
			scriptOut.println("<html><head>"); 
			scriptOut.println("<script>"); 
			scriptOut.println(" alert('登録が完了しました。'); "); 
			scriptOut.println(" opener.location.reload();"); 
			scriptOut.println(" window.close();"); 
			scriptOut.println("</script><body></body></html>"); 
					
			scriptOut.close(); 
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter scriptOut = response.getWriter(); 
					
			scriptOut.println("<html><head>"); 
			scriptOut.println("<script>"); 
			scriptOut.println(" alert('登録を失敗しました。'); "); 
			scriptOut.println(" opener.location.reload();"); 
			scriptOut.println(" window.close();"); 
			scriptOut.println("</script><body></body></html>"); 
					
			scriptOut.close(); 
		}
				
		
	}

}
