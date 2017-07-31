package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.admin.dto.ProductDTO;
import com.admin.dto.ProductMainUpdateDTO;
import com.util.DBManager;

public class ProductMainUpdateDAO {
	
	private ProductMainUpdateDAO(){}
	
	private static ProductMainUpdateDAO instance = new ProductMainUpdateDAO(); 
	public static ProductMainUpdateDAO getInstance(){
		return instance;
	}
	
	public ProductMainUpdateDTO showUpdateProductInfo(String seqNumber){
		
		// Query 선언
		String sql = "select  * from MainProductInfo M, AdditionalInfo A, HotelInfo H, TravelDayList T ";
				sql += "where M.mainproduct_no=A.mainproduct_no and A.mainproduct_no = H.mainproduct_no ";
				sql += "and H.mainproduct_no = T.mainproduct_no and M.mainproduct_no=?";
		
		// DTO List 및 Connection 초기화 
		ProductMainUpdateDTO dto = new ProductMainUpdateDTO();
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, seqNumber);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto.setMainproduct_no(rs.getString("mainproduct_no"));
				dto.setLocatecategory(rs.getString("locatecategory"));
				dto.setProductname(rs.getString("productname"));
				dto.setProductstatement(rs.getString("productstatement"));
				dto.setDepday(rs.getString("depday"));
				dto.setProductimage(rs.getString("productimage"));
				dto.setIncludelist(rs.getString("includelist"));
				dto.setExcludelist(rs.getString("excludelist"));
				dto.setChoicecost(rs.getString("choicecost"));
				dto.setRecommendcomment(rs.getString("recommendcomment"));
				dto.setDay1(rs.getString("day1"));
				dto.setDay2(rs.getString("day2"));
				dto.setDay3(rs.getString("day3"));
				dto.setDay4(rs.getString("day4"));
				dto.setDay5(rs.getString("day5"));
				dto.setHotelname(rs.getString("hotelname"));
				dto.setHotelimage(rs.getString("hotelimage"));
				dto.setHotelinfo(rs.getString("hotelinfo"));
				dto.setCaution(rs.getString("caution"));
				dto.setInsurunce(rs.getString("insurunce"));
				dto.setAgreement(rs.getString("agreement"));
				dto.setSafeinfo(rs.getString("safeinfo"));
				dto.setHelpphone(rs.getString("helpphone"));
				
			}
			System.out.println("DB처리완료");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}
	
	public void updateMainProduct(ProductMainUpdateDTO dto){
		
		// SQL QUERY 문
		String sql1 = "update mainproductinfo set productname = ?, productstatement=?, depday=?, productimage=?, ";
				sql1 += "includelist=? , excludelist=?, choicecost=?, recommendcomment = ? where mainproduct_no=?"; 
		String sql2 = "update traveldaylist set day1=?, day2=?, day3=?, day4=?, day5=? where mainproduct_no = ?"; 
		String sql3 = "update HotelInfo set hotelname=?, hotelimage=?, hotelinfo=? where mainproduct_no = ?";
		String sql4 = "update AdditionalInfo set caution=?, insurunce=?, agreement=?, safeinfo=?, helpphone=? where mainproduct_no = ?";
				
		// Connection 객체 초기화 
		Connection conn = null; 
		PreparedStatement pstmt = null;
		int count = 0; 
				
		//DB 처리 
		try{
			conn = DBManager.getConnection();
			
			// 1차 SQL UPDATE
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, dto.getProductname());
			pstmt.setString(2, dto.getProductstatement());
			pstmt.setString(3, dto.getDepday());
			pstmt.setString(4, dto.getProductimage());
			pstmt.setString(5, dto.getIncludelist());
			pstmt.setString(6, dto.getExcludelist());
			pstmt.setString(7, dto.getChoicecost());
			pstmt.setString(8, dto.getRecommendcomment());
			pstmt.setString(9, dto.getMainproduct_no());
			
			count += pstmt.executeUpdate(); 
			pstmt.close();
			
			// 2차 SQL UPDATE
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, dto.getDay1());
			pstmt.setString(2, dto.getDay2());
			pstmt.setString(3, dto.getDay3());
			pstmt.setString(4, dto.getDay4());
			pstmt.setString(5, dto.getDay5());
			pstmt.setString(6, dto.getMainproduct_no());
			
			count += pstmt.executeUpdate(); 
			pstmt.close();
			
			
			// 3차 SQL UPDATE
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, dto.getHotelname());
			pstmt.setString(2, dto.getHotelimage());
			pstmt.setString(3, dto.getHotelinfo());
			pstmt.setString(4, dto.getMainproduct_no());
						
			count += pstmt.executeUpdate(); 
			pstmt.close();
	
			// 4차 SQL UPDATE
			pstmt = conn.prepareStatement(sql3);
			pstmt.setString(1, dto.getCaution());
			pstmt.setString(2, dto.getInsurunce());
			pstmt.setString(3, dto.getAgreement());
			pstmt.setString(4, dto.getSafeinfo());
			pstmt.setString(5, dto.getHelpphone());
			pstmt.setString(6, dto.getMainproduct_no());
									
			count += pstmt.executeUpdate(); 
			
			System.out.println("총 DB Connection 횟수 : " + count + "회");
					
		}catch(SQLException e){
			e.printStackTrace();			
		} finally{
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
}
