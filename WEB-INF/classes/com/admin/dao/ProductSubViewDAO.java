package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.dto.ProductSubInsertDTO;
import com.admin.dto.ProductSubViewDTO;
import com.util.DBManager;

public class ProductSubViewDAO {
	// Singleton 생성 
	private ProductSubViewDAO(){}
	
	private static ProductSubViewDAO instance = new ProductSubViewDAO(); 
	public static ProductSubViewDAO getInstance(){
		return instance;
	}
	
	// 메인정보 보이기
		public ProductSubViewDTO showSubProductInfo(String seq){
			
			// Query 선언
			String sql = "select * from subproductinfo where subproduct_no=?";
			
			// DTO List 및 Connection 초기화 
			ProductSubViewDTO dto = new ProductSubViewDTO();
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null;
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, seq);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
								
					dto.setSubProductNo(rs.getString("subproduct_no"));
					dto.setMainProductNo(rs.getString("mainproduct_no"));
					dto.setSubStartDay(rs.getTimestamp("startday"));
					dto.setSubEndDay(rs.getTimestamp("endday"));
					dto.setSubAirLine(rs.getString("airline"));
					dto.setSubCost(rs.getInt("cost"));
					dto.setSubOilCost(rs.getInt("oilcost"));
					dto.setSubDueDate(rs.getTimestamp("duedate"));
					dto.setSubSellStatus(rs.getInt("sellstatus"));
					dto.setSubProductList(rs.getInt("productleast"));
							
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			}
			return dto;
		}
		
		public void showSubProductDelete(String seq){
			
			// Query 선언
			String sql = "delete subproductinfo where subproduct_no=?";
		
			
			// DTO List 및 Connection 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, seq);
				pstmt.executeUpdate();
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt);
			}
			
		}
		
		public void showSubProductChange(String seq){
			
			// Query 선언
			String sql = "update subproductinfo set sellstatus = 1 where subproduct_no =?";
		
			
			// DTO List 및 Connection 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, seq);
				pstmt.executeUpdate();
				
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt);
			}
			
		}
		
		public boolean subProductInsert(ProductSubInsertDTO dto){
			
			boolean flag = false; 
			// Query 선언
			String sql = "insert into subproductinfo values(?, ?,to_char(?,'yyyymmdd'), to_char(?,'yyyymmdd'), ?,?,?,to_char(?,'yyyymmdd'),0,?)";
			
			// DTO List 및 Connection 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, dto.getSubProductNo());
				pstmt.setString(2, dto.getMainProductNo());
				pstmt.setDate(3, dto.getSubStartDay());
				pstmt.setDate(4, dto.getSubEndDay());
				pstmt.setString(5, dto.getSubAirLine());
				pstmt.setInt(6, dto.getSubCost());
				pstmt.setInt(7, dto.getSubOilCost());
				pstmt.setDate(8, dto.getSubDueDate());
				pstmt.setInt(9, dto.getSubProductList());
				
				pstmt.executeQuery();
				flag = true; 
				
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt);
			}
			
			return flag; 
		}
		
		public String getSubProductNum(String mainSeq){
			String sql = "select * from (select subproduct_no from subproductinfo where mainproduct_no=? order by subproduct_no desc) where rownum = 1"; 
			String getSeqNumber = null;
			Connection conn = null; 
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, mainSeq);
				rs = pstmt.executeQuery();
						
				while(rs.next()){
					getSeqNumber = rs.getString("subproduct_no"); 
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, pstmt, rs);
			}				
			
			return getSeqNumber;
		}
}
