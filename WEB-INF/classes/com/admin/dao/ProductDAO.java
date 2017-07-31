package com.admin.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.admin.dto.ProductDTO; 
import com.util.DBManager; 

public class ProductDAO {
	
	// Singleton 생성 
	private ProductDAO(){}
	
	private static ProductDAO instance = new ProductDAO(); 
	public static ProductDAO getInstance(){
		return instance;
	}
	
	// 목록
	public List<ProductDTO> showMainProductInfo(int startRow, int endRow){
		
		// Query 선언
		String sql = "SELECT * FROM  (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS TOTCNT FROM (select mainproduct_no, productname from mainproductinfo order by mainproduct_no desc) A ) WHERE RNUM >= ? AND RNUM <= ?";
		
		// DTO List 및 Connection 초기화 
		List<ProductDTO> list = new ArrayList<ProductDTO>();
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
				ProductDTO dto = new ProductDTO();
				
				dto.setMainproduct_no(rs.getString("mainproduct_no"));
				dto.setProductname(rs.getString("productname"));
				
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
	
	
	
	// 상품 등록
	public void insertProduct(ProductDTO dto){
				
		// Query문 선언 
		String sql 
		= "insert all into "
		+ "MainProductInfo values (?,?,?,?,?,?,?,?,?,?,?,?) "
	    + "into AdditionalInfo values (?,?,?,?,?,?) "
	    + "into HotelInfo values (?,?,?,?,?,?) "
	    + "into TravelDayList values (?,?,?,?,?,?,?,?,?,?,?) "
	    + "SELECT * from dual";	
		
		// Connection 객체 생성
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		
		// DB문 실행
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getMainproduct_no());
			pstmt.setString(2, dto.getLocatecategory());
			pstmt.setString(3, dto.getProductname());
			pstmt.setString(4, dto.getProductstatement());
			pstmt.setTimestamp(5, dto.getProductduedate());
			pstmt.setTimestamp(6, dto.getDepdate());
			pstmt.setString(7, dto.getDepday());
			pstmt.setString(8, dto.getProductimage());
			pstmt.setString(9, dto.getIncludelist());
			pstmt.setString(10, dto.getExcludelist());
			pstmt.setString(11, dto.getChoicecost());
			pstmt.setString(12, dto.getRecommendcomment());
			
			pstmt.setString(13, dto.getMainproduct_no());
			pstmt.setString(14, dto.getCaution());
			pstmt.setString(15, dto.getAgreement());
			pstmt.setString(16, dto.getSafeinfo());
			pstmt.setString(17, dto.getInsurunce());
			pstmt.setString(18, dto.getHelpphone());
			
			pstmt.setString(19, dto.getMainproduct_no());
			pstmt.setString(20, dto.getHotelname());
			pstmt.setString(21, dto.getHoteladdress());
			pstmt.setString(22, dto.getHotelimage());
			pstmt.setString(23, dto.getMaplocation());
			pstmt.setString(24, dto.getHotelinfo());
			
			pstmt.setString(25, dto.getDay1());
			pstmt.setString(26, dto.getDay2());
			pstmt.setString(27, dto.getDay3());
			pstmt.setString(28, dto.getDay4());
			pstmt.setString(29, dto.getDay5());
			pstmt.setString(30, dto.getDay6());
			pstmt.setString(31, dto.getDay7());
			pstmt.setString(32, dto.getDay8());
			pstmt.setString(33, dto.getDay9());
			pstmt.setString(34, dto.getDay10());
			pstmt.setString(35, dto.getMainproduct_no());
			pstmt.executeQuery();
			System.out.println("상품등록 완료");
			
		}catch(SQLException e){
			e.printStackTrace();			
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	// 제품 총개수 가지고 오기
	public int getMainProductTotal(){
		String sql = "select count(*) as count from mainproductinfo"; 
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

	// 최근 상품 번호 가지고 오기 
		public String getProductAricleNum(String locateCategory){
			String sql = "select * from (select mainproduct_no from mainproductinfo where locateCategory='"+locateCategory+"' order by mainproduct_no desc) where rownum = 1"; 
			String getProductNumber = null;
			Connection conn = null; 
			Statement stmt = null;
			ResultSet rs = null;
			
			// DB 접근 및 Select문 처리
			try{
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					getProductNumber = rs.getString("mainproduct_no"); 
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBManager.close(conn, stmt, rs);
			}				
			
			return getProductNumber;
		}
	
}
