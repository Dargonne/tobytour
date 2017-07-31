package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.dto.MemberViewDTO;
import com.util.DBManager;

public class MemberViewDAO {
	private MemberViewDAO(){}
	
	private static MemberViewDAO instance = new MemberViewDAO(); 
	public static MemberViewDAO getInstance(){
		return instance;
	}
	
	// 선택 주문 목록을 보여주는 SQL Query
	public MemberViewDTO showChoiceMemberView(String prID){
				
		// Query 선언
		String sql = "select * from memberinfo where id=?";
				
		// DTO List 및 Connection 초기화 
		MemberViewDTO dto = new MemberViewDTO();
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
					
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, prID);
			rs = pstmt.executeQuery();
						
			while(rs.next()){
						dto.setMemberID(rs.getString("id"));
						dto.setMemberName(rs.getString("name"));
						dto.setMemberBirth(rs.getString("birth"));
						dto.setMemberSex(rs.getInt("sex"));
						dto.setMemberAddress(rs.getString("address"));
						dto.setMemberPhone(rs.getString("phone"));
						dto.setMemberEmailReceive(rs.getInt("emailrecieve"));
						dto.setMemberRestStatus(rs.getTimestamp("reststatus"));
						dto.setMemberJoinDate(rs.getTimestamp("joindate"));
						dto.setMemberLatestDate(rs.getTimestamp("latestdate"));
						dto.setMemberUserSection(rs.getInt("usersection"));

					}
					}catch(SQLException e){
						e.printStackTrace();
					}finally{
						DBManager.close(conn, pstmt, rs);
					}
					return dto;
				}
			
			
		public void updateMemberAdmin(String seqID){
				
			// SQL QUERY 문
			String sql = "update memberinfo set usersection = 1 where id=?"; 
						
			// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
						
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
					
				pstmt.setString(1, seqID);
				pstmt.executeUpdate(); 
							
			}catch(SQLException e){
				e.printStackTrace();			
			} finally{
				DBManager.close(conn, pstmt);
			}
				
		}
			
		public void updateMemberDelete(String seqID){
				
		// SQL QUERY 문
			String sql = "delete memberinfo where id=?"; 
						
		// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
						
		//DB 처리 
				try{
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, seqID);
					pstmt.executeUpdate(); 
							
				}catch(SQLException e){
					e.printStackTrace();			
				} finally{
					DBManager.close(conn, pstmt);
				}
				
			}
			
}
