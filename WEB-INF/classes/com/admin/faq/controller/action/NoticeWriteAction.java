package com.admin.faq.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.FaqDAO;
import com.admin.dto.FaqDTO;

public class NoticeWriteAction implements NoticeAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		// 최근 게시물 번호를 가져와서 을 데이터베이스에 등록하는 작업을 수행하는 Action Class 
		FaqDAO dao = FaqDAO.getInstance();
		String getRecentNum = dao.getNoticeAricleNum(); 
		String setRecentNum = null; 
		
		int numRecent = 0;
		
		if( getRecentNum != null)
		{	
			numRecent = Integer.parseInt(getRecentNum.substring(2, getRecentNum.length()));  
			
			numRecent++;
				
				
			if(numRecent>0 && numRecent<10)
			{
				setRecentNum = "NO0000" + String.valueOf(numRecent); 
			} else if(numRecent>9 && numRecent<100){
				setRecentNum = "NO000" + String.valueOf(numRecent); 
			}else if(numRecent>99 && numRecent<1000){
				setRecentNum = "NO00" + String.valueOf(numRecent); 
			}else if(numRecent>999 && numRecent<10000){
				setRecentNum = "NO0" + String.valueOf(numRecent); 
			}else if(numRecent >= 10000){
				setRecentNum = "NO" + String.valueOf(numRecent); 
			}
		} else {
			setRecentNum = "NO00001";
		}
		
		
		
		
				
		FaqDTO dto = new FaqDTO(); 
		dto.setNoticeSeq(setRecentNum);
		dto.setNoticeTitle(request.getParameter("title"));
		dto.setNoticeContent(request.getParameter("content"));
		
		//DB에 추가
		dao.insertNoticeArticle(dto);
		
		//List에 등록
		new NoticeListAction().execute(request, response);
		
	}

}
