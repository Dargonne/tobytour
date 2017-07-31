package com.admin.analysis.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AnalysisSalesDAO;
import com.admin.dto.AnalysisSalesDTO;


public class SalesListAction implements AnalysisAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/admin/analysis/sales_list.jsp";
		
		// 통계 그래프 작성을 위한 List 생성
		AnalysisSalesDAO dao = AnalysisSalesDAO.getInstance();
				
			if(dao.setSalesCount())
			{
				List<AnalysisSalesDTO> salesChartList = new ArrayList(); 
					
				salesChartList = dao.showWeeklySalesList();		
					
				Date now = new Date();
				DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
					
				String salesDay1 = dateFormat.format(salesChartList.get(0).getPaymentDay()).toString();
				String salesDay2 = dateFormat.format(salesChartList.get(1).getPaymentDay()).toString();
				String salesDay3 = dateFormat.format(salesChartList.get(2).getPaymentDay()).toString();
				String salesDay4 = dateFormat.format(salesChartList.get(3).getPaymentDay()).toString();
				String salesDay5 = dateFormat.format(salesChartList.get(4).getPaymentDay()).toString();
				String salesDay6 = dateFormat.format(salesChartList.get(5).getPaymentDay()).toString();
				String salesDay7 = dateFormat.format(salesChartList.get(6).getPaymentDay()).toString();

									
				int salesCost1 = salesChartList.get(0).getTotalCost();
				int salesCost2 = salesChartList.get(1).getTotalCost();
				int salesCost3 = salesChartList.get(2).getTotalCost();
				int salesCost4 = salesChartList.get(3).getTotalCost();
				int salesCost5 = salesChartList.get(4).getTotalCost();
				int salesCost6 = salesChartList.get(5).getTotalCost();
				int salesCost7 = salesChartList.get(6).getTotalCost();
					
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
				List<AnalysisSalesDTO> salesList = new ArrayList(); 

				count = dao.getNewMemberTotal();//전체 글의 수
				if (count > 0) {        
					if(endRow>count)
						endRow = count;
					salesList = dao.showAllSalesList(startRow, endRow);
				} else {
					salesList = null;
				}

				number=count-(currentPage-1)*PAGE_SIZE;//글목록에 표시할 글번호
				 
				//페이지그룹의 갯수 
				//ex) pageGroupSize가 3일 경우 '[1][2][3]'가 pageGroupCount 개 만큼 있다.  
				int pageGroupCount = count/(PAGE_SIZE*PAGE_GROUP_SIZE)+( count % (PAGE_SIZE*PAGE_GROUP_SIZE) == 0 ? 0 : 1);
				//페이지 그룹 번호 
				//ex) pageGroupSize가 3일 경우  '[1][2][3]'의 페이지그룹번호는 1 이고  '[2][3][4]'의 페이지그룹번호는 2 이다.
				int numPageGroup = (int) Math.ceil((double)currentPage/PAGE_GROUP_SIZE);
				//해당 뷰에서 사용할 속성
					 
				request.setAttribute("salesList", salesList);
				request.setAttribute("salesDay1", salesDay1);
				request.setAttribute("salesDay2", salesDay2);
				request.setAttribute("salesDay3", salesDay3);
				request.setAttribute("salesDay4", salesDay4);
				request.setAttribute("salesDay5", salesDay5);
				request.setAttribute("salesDay6", salesDay6);
				request.setAttribute("salesDay7", salesDay7);
				request.setAttribute("salesCost1", salesCost1);		
				request.setAttribute("salesCost2", salesCost2);
				request.setAttribute("salesCost3", salesCost3);
				request.setAttribute("salesCost4", salesCost4);
				request.setAttribute("salesCost5", salesCost5);
				request.setAttribute("salesCost6", salesCost6);
				request.setAttribute("salesCost7", salesCost7);		
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
