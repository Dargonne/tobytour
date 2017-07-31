package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.AnalysisDTO;
import com.util.DBManager; 

public class AnalysisDAO {
	
	// Singleton 생성 
	private AnalysisDAO(){}
	
	private static AnalysisDAO instance = new AnalysisDAO(); 
	public static AnalysisDAO getInstance(){
		return instance;
	}
	
		
	/*---------------------- 방문자수 분석 DAO 시작 ----------------------*/
	
	// 방문자수 최근 1주일 그래프를 위한 Query 
	public List<AnalysisDTO> showWeeklyCounterList(){
		String sql = "select visitday, sum(counter) as count from counter where visitday >= to_char(sysdate-7, 'YYMMDD') group by visitday";
		
		// DTO List 및 Connection 초기화 
		List<AnalysisDTO> list = new ArrayList<AnalysisDTO>();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				AnalysisDTO dto = new AnalysisDTO();
				
				dto.setVisitDay(rs.getTimestamp("visitday"));
				dto.setVisitCount(rs.getInt("count"));				
				list.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		return list;
	
	}
	
	
	// 전체 방문자수 응용
	public List<AnalysisDTO> showAllCouterList(int startRow, int endRow){

		// Query 선언
		String sql = "SELECT * FROM (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select visitday, sum(counter) as count from counter group by visitday order by visitday desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		
		// DTO List 및 Connection 초기화 
		List<AnalysisDTO> list = new ArrayList<AnalysisDTO>();
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
				AnalysisDTO dto = new AnalysisDTO();
				
				dto.setVisitDay(rs.getTimestamp("visitday"));
				dto.setVisitCount(rs.getInt("count"));
												
				list.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// Counter 총개수 가지고 오기 
	public int getRequestTotal(){
		String sql = "select distinct count(*) over() as count from counter group by visitday"; 
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
	
	public boolean setVisitorCount(){
		boolean flag = false; 
		Connection conn = DBManager.getConnection(); 
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			int checkCounter = 0;
			
			while(checkCounter < 7 ){
				String sql = "merge into counter using DUAL on (visitday = to_char(sysdate-" + checkCounter + ",'yymmdd'))";
				        sql += "when not matched then insert (visitday, counter)  values(to_char(sysdate-" + checkCounter+ ",'yymmdd'), 0)";

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
}
