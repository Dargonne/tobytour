package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.FaqRequestDTO;
import com.util.DBManager;
import com.web.dto.WebRequestDTO;

public class WebRequestDAO {
	private WebRequestDAO(){}
	
	private static WebRequestDAO instance = new WebRequestDAO(); 
	public static WebRequestDAO getInstance(){
		return instance;
	}
	
	// 1:1문의 목록 보이기
		public List<WebRequestDTO> showAllRequestArticle(String userID, int startRow, int endRow){
			
			// Query 선언
			String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (SELECT * FROM FAQ where id=? ORDER BY seq_faq desc ) A ) WHERE RNUM >= ? AND RNUM <= ?";
			
			// DTO List 및 Connection 초기화 
			List<WebRequestDTO> list = new ArrayList<WebRequestDTO>();
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, userID);
				pstmt.setString(2, String.valueOf(startRow));
				pstmt.setString(3, String.valueOf(endRow));
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					WebRequestDTO dto = new WebRequestDTO();
					
					dto.setRequestSeq(rs.getString("seq_faq"));
					dto.setRequestSection(rs.getString("section"));
					dto.setRequestID(rs.getString("id"));
					dto.setRequestMail(rs.getString("mail"));
					dto.setRequestPhone(rs.getString("phone"));
					dto.setRequestTitle(rs.getString("title"));
					dto.setRequestContent(rs.getString("content"));
					dto.setRequestReplyContent(rs.getString("replycontent"));
					dto.setRequestWriteDate(rs.getTimestamp("writedate"));
					dto.setRequestReplyDate(rs.getTimestamp("replydate"));
					dto.setRequestReplyStatus(rs.getInt("replystatus"));
					
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
		public int getRequestTotal(String userID){
			String sql = "select count(*) as total from FAQ where id=?"; 
			int getSeqNumber = 0;
			Connection conn = null; 
			PreparedStatement pstmt = null;
			ResultSet rs = null;
					
		// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, userID);
				rs = pstmt.executeQuery();
					
				while(rs.next()){
					getSeqNumber = rs.getInt("total"); 
				}
						
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			}						
			return getSeqNumber;
		}
		
		// 선택한 1:1문의 보기 
		public WebRequestDTO showChoiceRequestArticle(String userID, String seqNumber){
					
			// SQL문 실행 
			String sql = "select * from faq where seq_faq=? and id=?"; 
					
			// Connection 객체 초기화
			WebRequestDTO dto = new WebRequestDTO(); 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
					
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, seqNumber);
				pstmt.setString(2, userID);
				rs = pstmt.executeQuery();
						
				while(rs.next()){
					dto.setRequestSeq(rs.getString("seq_faq"));
					dto.setRequestSection(rs.getString("section"));
					dto.setRequestID(rs.getString("id"));
					dto.setRequestMail(rs.getString("mail"));
					dto.setRequestPhone(rs.getString("phone"));
					dto.setRequestTitle(rs.getString("title"));
					dto.setRequestContent(rs.getString("content"));
					dto.setRequestReplyContent(rs.getString("replycontent"));
					dto.setRequestWriteDate(rs.getTimestamp("writedate"));
					dto.setRequestReplyDate(rs.getTimestamp("replydate"));
					dto.setRequestReplyStatus(rs.getInt("replystatus"));
					System.out.println(rs.getInt("replystatus"));
					
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
		public void deleteRequestArticle(String noticeSeq, String userID){
					
			// SQL QUERY 문
			String sql = "delete faq WHERE seq_faq=? and id=?"; 
					
			// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
					
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, noticeSeq);
				pstmt.setString(2, userID);
				pstmt.executeUpdate(); 
						
			}catch(SQLException e){
				e.printStackTrace();			
			} finally{
				DBManager.close(conn, pstmt);
			}
		}
		
		// 사용자 정보 가지고 오기 
		public WebRequestDTO getUserInfo(String userID){
					
			// SQL QUERY 문
			String sql = "select id, name, phone from memberinfo where id=?"; 
					
			// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			WebRequestDTO dto = new WebRequestDTO(); 
			
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, userID);
				rs = pstmt.executeQuery(); 
				
				while(rs.next()){
					dto.setRequestID(rs.getString("id"));
					dto.setRequestUserName(rs.getString("name"));
					dto.setRequestPhone(rs.getString("phone"));
				}
						
			}catch(SQLException e){
				e.printStackTrace();			
			} finally{
				DBManager.close(conn, pstmt, rs);
			}
			
			return dto;
		}
		
		// 문의사항 등록 
		public void insertRequest(WebRequestDTO dto){
					
			// SQL QUERY 문
			String sql = "insert into faq values(?,?,?,?,?,?,?,null,sysdate,null,0)"; 
					
			// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getRequestSeq());
				pstmt.setString(2, dto.getRequestSection());
				pstmt.setString(3, dto.getRequestID());
				pstmt.setString(4, dto.getRequestMail());
				pstmt.setString(5, dto.getRequestPhone());
				pstmt.setString(6, dto.getRequestTitle());
				pstmt.setString(7, dto.getRequestContent());
				pstmt.executeUpdate();
						
			}catch(SQLException e){
				e.printStackTrace();			
			} finally{
				DBManager.close(conn, pstmt, rs);
			}
			
		}
		
		public String getRecentAricleNum(){
			String sql = "select * from (select seq_faq from faq order by seq_faq desc) where rownum = 1"; 
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
					getSeqNumber = rs.getString("seq_faq"); 
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, stmt, rs);
			}				
			
			return getSeqNumber;
		}
	
		
}
