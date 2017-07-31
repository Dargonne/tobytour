package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.AnalysisJoinDTO;
import com.admin.dto.AnalysisSalesDTO;
import com.util.DBManager;

public class AnalysisSalesDAO {
	private AnalysisSalesDAO(){}

	private static AnalysisSalesDAO instance = new AnalysisSalesDAO(); 
	
	public static AnalysisSalesDAO getInstance(){
		return instance;
	}
	
	/*---------------------- 매출현황 DAO 시작 ----------------------*/
	// 최근 1주일 매출기록를 위한 Query 
	public List<AnalysisSalesDTO> showWeeklySalesList(){
		String sql = "select salesday, sum(salescount) as sum from salesinfo where salesday > to_char(sysdate-7, 'YYMMDD') group by salesday order by salesday ASC";
		
		// DTO List 및 Connection 초기화 
		List<AnalysisSalesDTO> list = new ArrayList<AnalysisSalesDTO>();
		Connection conn = null; 
		Statement stmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);

			while(rs.next()){
				AnalysisSalesDTO dto = new AnalysisSalesDTO();
				
				dto.setPaymentDay(rs.getTimestamp("salesday"));
				dto.setTotalCost(rs.getInt("sum"));
				list.add(dto);				
			}

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		return list;
	
	}
	
	// 매출현황 목록을 보여주기 위한 Query
	public List<AnalysisSalesDTO> showAllSalesList(int startRow, int endRow){
		
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select salesday, sum(salescount) as sum from salesinfo group by salesday order by salesday desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
				
		// DTO List 및 Connection 초기화 
		List<AnalysisSalesDTO> allSalesList = new ArrayList<AnalysisSalesDTO>();
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
				AnalysisSalesDTO dto = new AnalysisSalesDTO();
				
				dto.setPaymentDay(rs.getTimestamp("salesday"));
				dto.setTotalCost(rs.getInt("sum"));
				allSalesList.add(dto);				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return allSalesList;
	}
	
	// Counter 총개수 가지고 오기 
	public int getNewMemberTotal(){
		String sql = "select distinct count(*) over() as count from salesinfo group by salesday"; 
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
	
	public boolean setSalesCount(){
		boolean flag = false; 
		Connection conn = DBManager.getConnection(); 
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			
			int checkCounter = 0;
			
			while(checkCounter < 7 ){
				String sql = "merge into salesinfo using DUAL on (salesday = to_char(sysdate-" + checkCounter + ",'yymmdd'))";
						sql += " when not matched then insert (salesday, salescount)  values(to_char(sysdate-" + checkCounter + ",'yymmdd'), 0)";

				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
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
