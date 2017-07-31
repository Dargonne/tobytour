package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.AnalysisJoinDTO;
import com.util.DBManager;

public class AnalysisJoinDAO {
	
	private AnalysisJoinDAO(){}

	private static AnalysisJoinDAO instance = new AnalysisJoinDAO(); 
	public static AnalysisJoinDAO getInstance(){
		return instance;
	}
	
	/*---------------------- 신규회원자수 분석 DAO 시작 ----------------------*/
	// 최근 1주일 회원가입자 그래프를 위한 Query 
	public List<AnalysisJoinDTO> showWeeklyNewMemberList(){
		String sql = "select joindate, sum(joincount) as count from memberjoininfo where joindate >= to_char(sysdate-7, 'YYMMDD') group by joindate order by joindate ASC";
		
		// DTO List 및 Connection 초기화 
		List<AnalysisJoinDTO> list = new ArrayList<AnalysisJoinDTO>();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				AnalysisJoinDTO dto = new AnalysisJoinDTO();
				
				dto.setNewMemberJoinDate(rs.getTimestamp("joindate"));
				dto.setNewMemberJoinCount(rs.getInt("count"));
				
				list.add(dto);				
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		return list;
	
	}
	
	// 가입현황 목록을 보여주기 위한 Query
	public List<AnalysisJoinDTO> showAllNewMemberList(int startRow, int endRow){
		
		
		// Query 선언
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select joindate, sum(joincount) as count from memberjoininfo group by joindate order by joindate desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		
		// DTO List 및 Connection 초기화 
		List<AnalysisJoinDTO> allMemberList = new ArrayList<AnalysisJoinDTO>();
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
				AnalysisJoinDTO dto = new AnalysisJoinDTO();
				
				dto.setNewMemberJoinDate(rs.getTimestamp("joindate"));
				dto.setNewMemberJoinCount(rs.getInt("count"));
				System.out.println("DB처리 완료");
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
		String sql = "SELECT joindate FROM memberjoininfo group by joindate"; 
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
				getSeqNumber += 1; 
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}						
		return getSeqNumber;
	}
	
	public boolean setJoinMemberCount(){
		boolean flag = false; 
		Connection conn = DBManager.getConnection(); 
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			int checkCounter = 0;
			
			while(checkCounter < 7 ){
				String sql = "merge into memberjoininfo using DUAL on (joindate = to_char(sysdate-" + checkCounter + ",'yymmdd'))";
				        sql += "when not matched then insert (joindate, joincount)  values(to_char(sysdate-" + checkCounter+ ",'yymmdd'), 0)";

				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				System.out.println(sql);
				
				checkCounter++;
				
				if(checkCounter == 7){
					flag = true; 
					break;
				}
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return flag; 
	}
	
	
	/*---------------------- 신규회원자수 분석 DAO 종료 ----------------------*/
}
