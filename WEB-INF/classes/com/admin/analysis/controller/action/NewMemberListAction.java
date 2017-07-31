package com.admin.analysis.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AnalysisJoinDAO;
import com.admin.dto.AnalysisJoinDTO;



public class NewMemberListAction implements AnalysisAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/analysis/member_join_list.jsp";
		
		// 통계 그래프 작성을 위한 List 생성
		AnalysisJoinDAO dao = AnalysisJoinDAO.getInstance();
		if(dao.setJoinMemberCount()){
			List<AnalysisJoinDTO> newLatestJoinCount = new ArrayList();
			
			newLatestJoinCount = dao.showWeeklyNewMemberList();
			
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			
			String joinDate1 = dateFormat.format(newLatestJoinCount.get(0).getNewMemberJoinDate()).toString();
			String joinDate2 = dateFormat.format(newLatestJoinCount.get(1).getNewMemberJoinDate()).toString();
			String joinDate3 = dateFormat.format(newLatestJoinCount.get(2).getNewMemberJoinDate()).toString();
			String joinDate4 = dateFormat.format(newLatestJoinCount.get(3).getNewMemberJoinDate()).toString();
			String joinDate5 = dateFormat.format(newLatestJoinCount.get(4).getNewMemberJoinDate()).toString();
			String joinDate6 = dateFormat.format(newLatestJoinCount.get(5).getNewMemberJoinDate()).toString();
			String joinDate7 = dateFormat.format(newLatestJoinCount.get(6).getNewMemberJoinDate()).toString();
			
			int joinCount1 = newLatestJoinCount.get(0).getNewMemberJoinCount();
			int joinCount2 = newLatestJoinCount.get(1).getNewMemberJoinCount();
			int joinCount3 = newLatestJoinCount.get(2).getNewMemberJoinCount();
			int joinCount4 = newLatestJoinCount.get(3).getNewMemberJoinCount();
			int joinCount5 = newLatestJoinCount.get(4).getNewMemberJoinCount();
			int joinCount6 = newLatestJoinCount.get(5).getNewMemberJoinCount();
			int joinCount7 = newLatestJoinCount.get(6).getNewMemberJoinCount();
			
			
			
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
			
		   // ArrayList articleList = new ArrayList(); // Paging 처리를 위한 ArrayList
			List<AnalysisJoinDTO> memberJoinAllList = new ArrayList(); 

			count = dao.getNewMemberTotal();//전체 글의 수
			 if (count > 0) {        
				 if(endRow>count)
					 endRow = count;
				 memberJoinAllList = dao.showAllNewMemberList(startRow, endRow);
				   
			 } else {
				 memberJoinAllList = null;
			 }

			number=count-(currentPage-1)*PAGE_SIZE;//글목록에 표시할 글번호
				 
			//페이지그룹의 갯수 
			//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.  
			int pageGroupCount = count/(PAGE_SIZE*PAGE_GROUP_SIZE)+( count % (PAGE_SIZE*PAGE_GROUP_SIZE) == 0 ? 0 : 1);
			//페이지 그룹 번호 
			//ex) pageGroupSize가 3일 경우  '[1][2][3]'의 페이지그룹번호는 1 이고  '[2][3][4]'의 페이지그룹번호는 2 이다.
			int numPageGroup = (int) Math.ceil((double)currentPage/PAGE_GROUP_SIZE);
			
			request.setAttribute("memberJoinAllList", memberJoinAllList);
			request.setAttribute("joinDate1", joinDate1);
			request.setAttribute("joinDate2", joinDate2);
			request.setAttribute("joinDate3", joinDate3);
			request.setAttribute("joinDate4", joinDate4);
			request.setAttribute("joinDate5", joinDate5);
			request.setAttribute("joinDate6", joinDate6);
			request.setAttribute("joinDate7", joinDate7);
			request.setAttribute("joinCount1", joinCount1);
			request.setAttribute("joinCount2", joinCount2);
			request.setAttribute("joinCount3", joinCount3);
			request.setAttribute("joinCount4", joinCount4);
			request.setAttribute("joinCount5", joinCount5);
			request.setAttribute("joinCount6", joinCount6);
			request.setAttribute("joinCount7", joinCount7);
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
		} else {
			response.setContentType("text/html; charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			PrintWriter scriptOut = response.getWriter();
			
			scriptOut.println("<html><head>");
			scriptOut.println("<script>");
			scriptOut.println(" alert('統計データを呼んで来なかったです。 再び試みてください。');");
			scriptOut.println(" history.back();");
			scriptOut.println(" </script></head><body></body></html>");
			
			scriptOut.close();
		}

	}

}
