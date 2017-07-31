package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.ProductDTO;
import com.admin.dto.ProductMainViewDTO;
import com.util.DBManager; 

public class ProductMainViewDAO {
	
	// Singleton 생성 
	private ProductMainViewDAO(){}
	
	private static ProductMainViewDAO instance = new ProductMainViewDAO(); 
	public static ProductMainViewDAO getInstance(){
		return instance;
	}
	
	// 메인정보 보이기
	public ProductMainViewDTO showMainProductInfo(String seq){
		
		// Query 선언
		String sql = "select *  from mainproductinfo M , hotelinfo H where M.mainproduct_no = H.mainproduct_no and M.mainproduct_no =?";
		
		
		// DTO List 및 Connection 초기화 
		ProductMainViewDTO dto = new ProductMainViewDTO();
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
							
				dto.setMainProductNo(rs.getString("mainProduct_no"));
				dto.setMainProductImage(rs.getString("productimage"));
				dto.setMainProductName(rs.getString("productname"));
				dto.setMainDepDay(rs.getString("depday"));
				dto.setMainIncludeList(rs.getString("includelist"));
				dto.setMainExcludelist(rs.getString("excludelist"));
				dto.setMainChoiceCost(rs.getString("choicecost"));
				dto.setMainHotelImage(rs.getString("hotelimage"));
				dto.setMainHotelName(rs.getString("hotelname"));
				dto.setMainHotelInfo(rs.getString("hotelinfo"));
						
			}
			System.out.println("DB처리완료");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	
	// 목록
	public List<ProductMainViewDTO> showChoiceProductInfo(String seqNum, int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM ";
				sql	+= "(select subproduct_no, startday, endday, airline, productleast from Subproductinfo ";
				sql += "where mainproduct_no =? order by startday asc) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<ProductMainViewDTO> list = new ArrayList<ProductMainViewDTO>();
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, seqNum);
			pstmt.setString(2, String.valueOf(startRow));
			pstmt.setString(3, String.valueOf(endRow));
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ProductMainViewDTO dto = new ProductMainViewDTO();
				
				dto.setSubProductNo(rs.getString("subproduct_no"));
				dto.setSubStartDay(rs.getTimestamp("startday"));
				dto.setSubEndDay(rs.getTimestamp("endday"));
				dto.setSubAirLine(rs.getString("airline"));
				dto.setSubProductLeast(rs.getInt("productleast"));				
				
				list.add(dto);				
			}
			System.out.println("DB처리완료");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	// Counter 총개수 가지고 오기 
	public int getSubProductTotal(String seq){
		String sql = "select count(*) as count from subproductinfo where mainproduct_no=?"; 
		System.out.println(seq);
		int getSeqNumber = 0;
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
				getSeqNumber = rs.getInt("COUNT"); 
			}
						
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}						
		return getSeqNumber;
	}
	
	// 메인상품정보 삭제
	public void mainProductDelete(String seqID){
		
		// SQL QUERY 문
			String sql = "delete mainproductinfo where mainproduct_no=?"; 
						
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
