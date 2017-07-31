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

import com.admin.dao.FaqRequestDAO;
import com.web.dao.WebRequestDAO;
import com.web.dto.WebRequestDTO;


public class WebRequestListAction implements WebRequestAction{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/web/mypage/request_list.jsp";
		
		HttpSession session = request.getSession();
	    String userID= (String) session.getAttribute("id"); 
	        
	    if(userID == null){   	
	      response.setContentType("text/html; charset=utf-8"); 
	      PrintWriter out = response.getWriter();
				
		  out.println("<html><head>");
		  out.println("<script>");
		  out.println(" alert('ﾛｸﾞｲﾝした状態ではありません。 ﾛｸﾞｲﾝしてください。');");
		  out.println(" history.back();"); 
		  out.println("</script></head><body></body></html>"); 
				
	      out.close();	
	    }
	        
		// 페이징 처리 
	     final int PAGE_SIZE = 9;
		//페이지그룹안의 페이지 갯수 ex) [이전] 1 2 3 4 5 [다음] 일 경우 페이지 갯수는 5
				    
		 final int PAGE_GROUP_SIZE = 3;
				    
		 String pageNum = request.getParameter("page");//페이지 번호
		 
		 if (pageNum == null) {
		      pageNum = "1";
		 }        
		 
		 int currentPage = Integer.parseInt(pageNum);
		 int startRow = (currentPage - 1) * PAGE_SIZE + 1;//한 페이지의 시작글 번호
		 int endRow = currentPage * PAGE_SIZE;//한 페이지의 마지막 글번호
		 int count = 0;
		 int number=0;
		// 페이징 처리 변수선언 끝
        List<WebRequestDTO> requestList = new ArrayList();
        WebRequestDAO dao = WebRequestDAO.getInstance();

		count = dao.getRequestTotal(userID);//전체 글의 수

		 if (count > 0) {        
			 if(endRow>count)
				 endRow = count;
			     requestList = dao.showAllRequestArticle(userID, startRow, endRow);
		 } else {
			 requestList = null;
		 }

		number=count-(currentPage-1)*PAGE_SIZE;//글목록에 표시할 글번호
			 
		//페이지그룹의 갯수 
		//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.  
		int pageGroupCount = count/(PAGE_SIZE*PAGE_GROUP_SIZE)+( count % (PAGE_SIZE*PAGE_GROUP_SIZE) == 0 ? 0 : 1);
		//페이지 그룹 번호 
		//ex) pageGroupSize가 3일 경우  '[1][2][3]'의 페이지그룹번호는 1 이고  '[2][3][4]'의 페이지그룹번호는 2 이다.
		int numPageGroup = (int) Math.ceil((double)currentPage/PAGE_GROUP_SIZE);
		
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("requestList", requestList);
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
		//return "./";//해당 뷰
	}

}
