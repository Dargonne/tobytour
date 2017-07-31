package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.FaqDTO;
import com.admin.dto.OrderListDTO;
import com.admin.dto.OrderViewDTO;
import com.util.DBManager;

public class OrderViewDAO {
	private OrderViewDAO(){}
	
	private static OrderViewDAO instance = new OrderViewDAO(); 
	public static OrderViewDAO getInstance(){
		return instance;
	}
	
		// 선택 주문 목록을 보여주는 SQL Query
		public OrderViewDTO showAllPurchaseView(String prNum){
			
			// Query 선언
			String sql = "select * from purchaseinfo where seq_purchase=?";
			
			// DTO List 및 Connection 초기화 
			OrderViewDTO dto = new OrderViewDTO();
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
				
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, prNum);
				rs = pstmt.executeQuery();
					
				while(rs.next()){
					dto.setViewPurchaseSeq(rs.getString("seq_purchase"));
					dto.setViewPurchaseProductCode(rs.getString("subproduct_no"));
					dto.setViewPurchaseID(rs.getString("id"));
					dto.setViewPurchaseTraveler(rs.getString("traveler"));
					dto.setViewPurchaseTotalCost(rs.getInt("totalcost"));
					dto.setViewPurchasePaymentMeasure(rs.getInt("paymentmeasure"));
					dto.setViewPurchasePaymentResult(rs.getInt("paymentstatus"));
					dto.setViewPurchasePaymentDate(rs.getTimestamp("paymentday"));
					dto.setViewPurchaseCancelStatus(rs.getInt("cancelstatus"));	
				}
				}catch(SQLException e){
					e.printStackTrace();
				}finally{
					DBManager.close(conn, pstmt, rs);
				}
				return dto;
			}
		
		
		public void updateChangePayment(String seqNum){
			
			// SQL QUERY 문
			String sql = "update purchaseinfo set paymentstatus = 1 where seq_purchase=?"; 
					
			// Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
					
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, seqNum);
				pstmt.executeUpdate(); 
						
			}catch(SQLException e){
				e.printStackTrace();			
			} finally{
				DBManager.close(conn, pstmt);
			}
			
		}
}
