package com.admin.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.admin.dto.FaqDTO; 
import com.util.DBManager; 

public class FaqDAO {
	
	// Singleton 생성 
	private FaqDAO(){}
	
	private static FaqDAO instance = new FaqDAO(); 
	public static FaqDAO getInstance(){
		return instance;
	}
	
	/*---------------------- 공지사항 DAO 시작 ----------------------*/
	
	// 공지사항 목록 보이기
	public List<FaqDTO> showAllNoticeArticle(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (SELECT * FROM NOTICE ORDER BY seq_notice desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<FaqDTO> list = new ArrayList<FaqDTO>();
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
				FaqDTO dto = new FaqDTO();
				
				dto.setNoticeSeq(rs.getString("seq_notice"));
				dto.setNoticeTitle(rs.getString("title"));
				dto.setNoticeWriteDate(rs.getTimestamp("noticedate"));
				list.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 최근 게시물 번호 가지고 오기 
	public String getNoticeAricleNum(){
		String sql = "select * from (select seq_notice from notice order by seq_notice desc) where rownum = 1"; 
		String getSeqNumber = null;
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
					
			while(rs.next()){
				getSeqNumber = rs.getString("seq_notice"); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}				
		
		return getSeqNumber;
	}
	
	// 최근 게시물 번호 가지고 오기 
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
	
	// 새로운 공지사항 등록
	public void insertNoticeArticle(FaqDTO dto){
				
		// Query문 선언 
		String sql = "INSERT INTO Notice VALUES(?,?,?,SYSDATE,0)";
		
		// Connection 객체 생성
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		
		// DB문 실행
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getNoticeSeq());
			pstmt.setString(2, dto.getNoticeTitle());
			pstmt.setString(3, dto.getNoticeContent());
			pstmt.executeQuery();
			
		}catch(SQLException e){
			e.printStackTrace();			
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	// 선택한 공지사항 보기 
	public FaqDTO showChoiceNoticeArticle(String seqNumber){
		
		// SQL문 실행 
		String sql = "select * from notice where seq_notice=?"; 
		
		// Connection 객체 초기화
		FaqDTO dto = new FaqDTO(); 
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
				dto.setNoticeWriteDate(rs.getTimestamp("noticedate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return dto;
		
	}
	
	// 공지사항 수정 
	public void updateNoticeArticle(FaqDTO dto){
		
		// SQL QUERY 문
		String sql = "UPDATE Notice SET TITLE=?,CONTENT=? WHERE seq_notice=?"; 
		
		
		// Connection 객체 초기화 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		
		
		//DB 처리 
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getNoticeTitle());
			pstmt.setString(2, dto.getNoticeContent());
			pstmt.setString(3, dto.getNoticeSeq());
			
			pstmt.executeUpdate(); 
			
		}catch(SQLException e){
			e.printStackTrace();
			
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	// 공지사항 삭제 
	public void deleteNoticeArticle(String seqNumber){
		
		//SQL 문 생성 
		String sql = "DELETE Notice WHERE seq_notice=?"; 
		
		//Connection 객체 초기화 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		
		//DB 처리 
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, seqNumber.trim());
			pstmt.executeUpdate(); 
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	/*---------------------- 공지사항 DAO 종료 ----------------------*/
	
	/*---------------------- 1대1 문의 DAO 시작 ----------------------*/
	// 공지사항 목록 보이기
	public List<FaqDTO> showAllRequestArticle(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (SELECT * FROM FAQ ORDER BY seq_faq desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<FaqDTO> list = new ArrayList<FaqDTO>();
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
				FaqDTO dto = new FaqDTO();
				
				dto.setRequestSeq(rs.getString("seq_faq"));
				dto.setRequestTitle(rs.getString("title"));
				dto.setRequestID(rs.getString("id"));
				dto.setRequestWriteDate(rs.getTimestamp("writedate"));
				dto.setRequestReply(rs.getInt("replystatus"));

				list.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// 최근 게시물 번호 가지고 오기 
	public int getRequestTotal(){
		String sql = "select count(*) AS total from faq"; 
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
	
	// 선택한 1:1문의 보기 
	public FaqDTO showChoiceRequestArticle(String seqNumber){
				
		// SQL문 실행 
		String sql = "select * from faq where seq_faq=?"; 
				
		// Connection 객체 초기화
		FaqDTO dto = new FaqDTO(); 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
				
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seqNumber);
			rs = pstmt.executeQuery();
					
			while(rs.next()){
				dto.setRequestID(rs.getString("seq_faq"));
				dto.setRequestPhone(rs.getString("phone"));
				dto.setRequestMail(rs.getString("mail"));
				dto.setRequestWriteDate(rs.getTimestamp("writedate"));
				dto.setRequestContent(rs.getString("content"));
				dto.setRequestReply(rs.getInt("replystatus"));
				dto.setRequestReplyDate(rs.getTimestamp("replydate"));
				dto.setRequestReplyContent(rs.getString("replycontent"));
			}
		}catch(SQLException e){
				e.printStackTrace();
		} finally{
				DBManager.close(conn, pstmt, rs);
		}
				
		return dto;
				
	}
			
	// 공지사항 수정 
	public void updateRequestArticle(FaqDTO dto){
				
		// SQL QUERY 문
		String sql = "UPDATE faq SET replycontent=?, replydate=sysdate, replystatus=1 WHERE seq_faq=?"; 
				
		// Connection 객체 초기화 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
				
		//DB 처리 
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, dto.getRequestReplyContent());
			pstmt.setString(2, dto.getRequestSeq());
			pstmt.executeUpdate(); 
					
		}catch(SQLException e){
			e.printStackTrace();			
		} finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	
}
