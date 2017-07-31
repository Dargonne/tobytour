package com.admin.analysis.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AnalysisDAO;
import com.admin.dto.AnalysisDTO;

public class VisitCounterAction implements AnalysisAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/analysis/member_counter_list.jsp";
		
		// 통계 그래프 작성을 위한 List 생성
		AnalysisDAO dao = AnalysisDAO.getInstance();
		if(dao.setVisitorCount())
		{
			List<AnalysisDTO> counterChartList = new ArrayList(); 
		
			counterChartList = dao.showWeeklyCounterList();		
		
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
			String visitDay1 = dateFormat.format(counterChartList.get(0).getVisitDay()).toString();
			String visitDay2 = dateFormat.format(counterChartList.get(1).getVisitDay()).toString();
			String visitDay3 = dateFormat.format(counterChartList.get(2).getVisitDay()).toString();
			String visitDay4 = dateFormat.format(counterChartList.get(3).getVisitDay()).toString();
			String visitDay5 = dateFormat.format(counterChartList.get(4).getVisitDay()).toString();
			String visitDay6 = dateFormat.format(counterChartList.get(5).getVisitDay()).toString();
			String visitDay7 = dateFormat.format(counterChartList.get(6).getVisitDay()).toString();

		
			int visitCount1 = counterChartList.get(0).getVisitCount();
			int visitCount2 = counterChartList.get(1).getVisitCount();
			int visitCount3 = counterChartList.get(2).getVisitCount();
			int visitCount4 = counterChartList.get(3).getVisitCount();
			int visitCount5 = counterChartList.get(4).getVisitCount();
			int visitCount6 = counterChartList.get(5).getVisitCount();
			int visitCount7 = counterChartList.get(6).getVisitCount();

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
		
			
			List<AnalysisDTO> counterAllList = new ArrayList(); 

			count = dao.getRequestTotal();//전체 글의 수
			if (count > 0) {        
				if(endRow>count)
					endRow = count;
					counterAllList = dao.showAllCouterList(startRow, endRow);
			   
			} else {
				counterAllList = null;
			}

			number=count-(currentPage-1)*PAGE_SIZE;//글목록에 표시할 글번호
			 
			//페이지그룹의 갯수 
			//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.  
			int pageGroupCount = count/(PAGE_SIZE*PAGE_GROUP_SIZE)+( count % (PAGE_SIZE*PAGE_GROUP_SIZE) == 0 ? 0 : 1);
			//페이지 그룹 번호 
			//ex) pageGroupSize가 3일 경우  '[1][2][3]'의 페이지그룹번호는 1 이고  '[2][3][4]'의 페이지그룹번호는 2 이다.
			int numPageGroup = (int) Math.ceil((double)currentPage/PAGE_GROUP_SIZE);
			
			request.setAttribute("counterAllList", counterAllList);
			request.setAttribute("visitDay1", visitDay1);
			request.setAttribute("visitDay2", visitDay2);
			request.setAttribute("visitDay3", visitDay3);
			request.setAttribute("visitDay4", visitDay4);
			request.setAttribute("visitDay5", visitDay5);
			request.setAttribute("visitDay6", visitDay6);
			request.setAttribute("visitDay7", visitDay7);
			request.setAttribute("visitCount1", visitCount1);
			request.setAttribute("visitCount2", visitCount2);
			request.setAttribute("visitCount3", visitCount3);
			request.setAttribute("visitCount4", visitCount4);
			request.setAttribute("visitCount5", visitCount5);
			request.setAttribute("visitCount6", visitCount6);
			request.setAttribute("visitCount7", visitCount7);
			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(PAGE_SIZE));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("pageGroupSize", new Integer(PAGE_GROUP_SIZE));
			request.setAttribute("numPageGroup", new Integer(numPageGroup));
			request.setAttribute("pageGroupCount", new Integer(pageGroupCount));
			
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
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
