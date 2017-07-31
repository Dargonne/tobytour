package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.MemberListDTO;
import com.util.DBManager;

public class MemberListDAO {
	
	private MemberListDAO(){}
	
	private static MemberListDAO instance = new MemberListDAO(); 
	public static MemberListDAO getInstance(){
		return instance;
	}
	
	// 전체 주문 목록을 보여주는 SQL Query
	public List<MemberListDTO> showAllMemberList(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select * from memberinfo order by joindate desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
			
		// DTO List 및 Connection 초기화 
		List<MemberListDTO> allMemberList = new ArrayList<MemberListDTO>();
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
				MemberListDTO dto = new MemberListDTO();
				
				dto.setMemberNum(rs.getInt("RNUM"));
				dto.setMemberID(rs.getString("id"));
				dto.setMemberName(rs.getString("name"));
				dto.setMemberPhone(rs.getString("phone"));
				dto.setMemberJoinDate(rs.getTimestamp("joindate"));
				dto.setMemberUserSection(rs.getInt("usersection"));
				
				allMemberList.add(dto);				
			}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			}
			return allMemberList;
		}
		
	// Counter 총개수 가지고 오기 
	public int getNewMemberTotal(){
		String sql = "select count(*) as count from memberinfo"; 
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
				getSeqNumber = rs.getInt("count"); 
			}
						
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}						
		return getSeqNumber;
	}
	
	
}
