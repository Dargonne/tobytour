package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.OrderListDTO;
import com.util.DBManager;

public class OrderListDAO {
	
	// Singleton 생성 
	private OrderListDAO(){}
	
	private static OrderListDAO instance = new OrderListDAO(); 
	public static OrderListDAO getInstance(){
		return instance;
	}
	
	// 전체 주문 목록을 보여주는 SQL Query
	public List<OrderListDTO> showAllPurchaseList(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select * from purchaseinfo order by seq_purchase desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
			
		// DTO List 및 Connection 초기화 
		List<OrderListDTO> allPurchaseList = new ArrayList<OrderListDTO>();
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
				OrderListDTO dto = new OrderListDTO();
					
				dto.setOrderListSeq(rs.getString("seq_purchase"));
				dto.setOrderListSubProductNo(rs.getString("subproduct_no"));
				dto.setOrderListID(rs.getString("id"));
				dto.setOrderListTotalCost(rs.getInt("totalcost"));
				dto.setOrderDay(rs.getTimestamp("paymentday"));
				dto.setOrderListPaymentMeasure(rs.getInt("paymentmeasure"));
				dto.setOrderListPaymentStatus(rs.getInt("paymentstatus"));
				dto.setOrderListCancelStatus(rs.getInt("cancelstatus"));
					
				allPurchaseList.add(dto);				
			}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			}
			return allPurchaseList;
		}
		
	// Counter 총개수 가지고 오기 
	public int getNewMemberTotal(){
		String sql = "select count(*) as count from purchaseinfo"; 
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
