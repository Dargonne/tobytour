package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.FaqDTO;
import com.util.DBManager;
import com.web.dto.RegisterDTO;
import com.web.dto.WebNoticeDTO;

public class WebNoticeDAO {
	private WebNoticeDAO(){}
	
	private static WebNoticeDAO instance = new WebNoticeDAO(); 
	public static WebNoticeDAO getInstance(){
		return instance;
	}
	
	// 공지사항 목록 보이기
	public List<WebNoticeDTO> showAllNoticeList(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (SELECT * FROM NOTICE ORDER BY seq_notice desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<WebNoticeDTO> list = new ArrayList<WebNoticeDTO>();
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, String.valueOf(startRow));
			pstmt.setString(2, String.valueOf(endRow));
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				WebNoticeDTO dto = new WebNoticeDTO();
				dto.setNoticeSeq(rs.getString("seq_notice"));
				dto.setNoticeTitle(rs.getString("title"));
				dto.setNoticeContent(rs.getString("content"));
				dto.setNoticeDate(rs.getTimestamp("noticedate"));
				dto.setNoticeCount(rs.getInt("count"));
				list.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int getNoticeTotal(){
		String sql = "select count(*) AS total from notice"; 
		int getSeqNumber = 0;
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
					
			while(rs.next()){
				getSeqNumber = rs.getInt("total"); 
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}				
		
		return getSeqNumber;
	}
	
	public WebNoticeDTO showChoiceNoticeArticle(String seqNumber){
			
		// SQL문 실행 
		String sql = "select * from notice where seq_notice=?"; 
			
		// Connection 객체 초기화
		WebNoticeDTO dto = new WebNoticeDTO(); 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
			
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seqNumber);
			rs = pstmt.executeQuery();
				
			while(rs.next()){
				dto.setNoticeSeq(rs.getString("seq_notice"));
				dto.setNoticeTitle(rs.getString("title"));
				dto.setNoticeContent(rs.getString("content"));
				dto.setNoticeDate(rs.getTimestamp("noticedate"));
				dto.setNoticeCount(rs.getInt("count"));				
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
			
		return dto;
			
	}
	
	// 조회수 1씩 증가 
		public void updateCount(String noticeSeq){

		// Query문 선언 
		String sql = "UPDATE notice SET count = nvl(count, 0) + 1 where seq_notice=?";
				
		// Connection 객체 생성
		Connection conn = null; 
		PreparedStatement pstmt = null; 
				
		// DB문 실행
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, noticeSeq);			
			pstmt.executeUpdate(); 

		}catch(SQLException e){
			e.printStackTrace();			
		}finally {
			DBManager.close(conn, pstmt);
		}
				
		}
		
}
