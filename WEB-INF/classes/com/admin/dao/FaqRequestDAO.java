package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.FaqRequestDTO;
import com.util.DBManager; 

public class FaqRequestDAO {
	
	// Singleton 생성 
	private FaqRequestDAO(){}
	
	private static FaqRequestDAO instance = new FaqRequestDAO(); 
	public static FaqRequestDAO getInstance(){
		return instance;
	}
	
		
	/*---------------------- 1대1 문의 DAO 시작 ----------------------*/
	// 1:1문의 목록 보이기
	public List<FaqRequestDTO> showAllRequestArticle(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (SELECT * FROM FAQ ORDER BY seq_faq desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<FaqRequestDTO> list = new ArrayList<FaqRequestDTO>();
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
				FaqRequestDTO dto = new FaqRequestDTO();
				
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
	
	// 게시물 총개수 가지고 오기 
	public int getRequestTotal(){
		String sql = "select count(*) as total from FAQ"; 
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
	public FaqRequestDTO showChoiceRequestArticle(String seqNumber){
				
		// SQL문 실행 
		String sql = "select * from faq where seq_faq=?"; 
				
		// Connection 객체 초기화
		FaqRequestDTO dto = new FaqRequestDTO(); 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
				
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seqNumber);
			rs = pstmt.executeQuery();
					
			while(rs.next()){
				dto.setRequestSeq(rs.getString("seq_faq"));
				dto.setRequestSection(rs.getString("section"));
				dto.setRequestID(rs.getString("ID"));
				dto.setRequestTitle(rs.getString("title"));
				dto.setRequestWriteDate(rs.getTimestamp("writedate"));
				dto.setRequestPhone(rs.getString("phone"));
				dto.setRequestContent(rs.getString("content"));
				dto.setRequestReply(rs.getInt("replystatus"));
				dto.setRequestReplyContent(rs.getString("replycontent"));
				
				System.out.println("공지사항 답변글 작성 DB처리 완료");
			}
		}catch(SQLException e){
				e.printStackTrace();
		} finally{
				DBManager.close(conn, pstmt, rs);
		}
				
		return dto;
				
	}
			
	// 공지사항 수정 
	public void updateRequestArticle(FaqRequestDTO dto){
				
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
