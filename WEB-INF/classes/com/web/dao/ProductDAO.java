package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.dto.ProductDTO;

import com.util.DBManager;

public class ProductDAO {
	 private ProductDAO(){}
	   
	   private static ProductDAO instance=new ProductDAO();
	   
	   public static ProductDAO getInstance(){
	      return instance;
}


	  /* 코드 작성 ! */
	 

		public List<ProductDTO> selectAllProduction() {
			String sql = "select * from MainProductInfo";
			List<ProductDTO> list = new ArrayList<ProductDTO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try{
				conn =DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while (rs.next()){
					ProductDTO dto = new ProductDTO();
					
					dto.setMainproduct_no(rs.getString("mainproduct_no"));
					dto.setLocatecategory(rs.getString("locatecategory"));
					dto.setProductname(rs.getString("productname"));
					dto.setProductstatement(rs.getString("productstatement"));
					dto.setProductduedate(rs.getTimestamp("productduedate"));
					dto.setDepdate(rs.getTimestamp("depdate"));
					dto.setDepday(rs.getString("depday"));
					dto.setProductimage(rs.getString("productimage"));
					dto.setIncludelist(rs.getString("includelist"));
					dto.setExcludelist(rs.getString("excludelist"));
					dto.setChoicecost(rs.getString("choicecost"));
					dto.setRecommendcomment(rs.getString("recommendcomment"));
					
					list.add(dto);
				}
			
				
			}catch(SQLException e){
		         e.printStackTrace();
		      }finally{
		         DBManager.close(conn, stmt, rs);
		      }
		      return list;
		}
		

		
	public List<ProductDTO> selectSubProductInfo(String mainSeq) {
		String sql = "  select * from SubProductInfo where mainproduct_no='" + mainSeq + "' and sellstatus=0";
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println(sql);
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				ProductDTO dto = new ProductDTO();
				
				dto.setSubproduct_no(rs.getString("subproduct_no"));
				dto.setStartday(rs.getTimestamp("startday"));
				dto.setEndday(rs.getTimestamp("endday"));
				dto.setAirline(rs.getString("airline"));
				dto.setCost(rs.getInt("cost"));
				dto.setProductleast(rs.getInt("productleast"));
				list.add(dto);}
			
				
			}catch(SQLException e){
		         e.printStackTrace();
		      }finally{
		         DBManager.close(conn, stmt, rs);
		      }
		      return list;
		}
			

		public ProductDTO selectOnePurchase(String mainproduct_no) {
			String sql = "select * from MainProductInfo M , SubProductInfo S where M.mainproduct_no = S.mainproduct_no and S.mainproduct_no=? and sellstatus=0";
			ProductDTO dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			System.out.println(mainproduct_no);
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mainproduct_no);
				rs = pstmt.executeQuery();
				if(rs.next()){					
					dto = new ProductDTO();
					
					dto.setProductname(rs.getString("productname"));
					dto.setStartday(rs.getTimestamp("startday"));
					dto.setEndday(rs.getTimestamp("endday"));
					dto.setCost(rs.getInt("cost"));
					dto.setChoicecost(rs.getString("choicecost"));
					
					
				}	}catch(SQLException e){
			    	  e.printStackTrace();
			      }finally {
			    	  DBManager.close(conn, pstmt, rs);
				}return dto ;
			   }
		
		public ProductDTO selectPurchase(String subproduct_no) {
			String sql = "select * from SubProductInfo S , PurchaseInfo P where S.subproduct_no  = P.subproduct_no  and P.subproduct_no  = ? and sellstatus=0";
			
			ProductDTO dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			System.out.println(subproduct_no);
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, subproduct_no);
				rs = pstmt.executeQuery();
				if(rs.next()){
					dto = new ProductDTO();
					
					dto.setProductname(rs.getString("productname"));
					dto.setStartday(rs.getTimestamp("startday"));
					dto.setEndday(rs.getTimestamp("endday"));
					dto.setId(rs.getString("id"));
					dto.setTraveler(rs.getString("traveler"));
					dto.setTravelerinfo(rs.getString("travelerinfo"));
					dto.setTotalcost(rs.getInt("totalcost"));
					
					
				}
			}catch(SQLException e){
		    	  e.printStackTrace();
		      }finally {
		    	  DBManager.close(conn, pstmt, rs);
			}return dto ;
		   }

	
		public ProductDTO selectOneProduction(String mainproduct_no) {
			String sql = "select * from MainProductInfo M, AdditionalInfo A, HotelInfo H, TravelDayList T where M.mainproduct_no=A.mainproduct_no and A.mainproduct_no = H.mainproduct_no and H.mainproduct_no = T.mainproduct_no and M.mainproduct_no=?";
			
			ProductDTO dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			System.out.println(mainproduct_no);
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mainproduct_no);
				rs = pstmt.executeQuery();
				if(rs.next()){
					dto = new ProductDTO();
					
					dto.setProductname(rs.getString("productname"));
					dto.setProductimage(rs.getString("productimage"));
					dto.setProductstatement(rs.getString("productstatement"));
					dto.setRecommendcomment(rs.getString("recommendcomment"));
					dto.setDepday(rs.getString("depday"));
					dto.setIncludelist(rs.getString("includelist"));
					dto.setExcludelist(rs.getString("excludelist"));	
			
					
					dto.setHotelimage(rs.getString("hotelimage"));
					dto.setHotelname(rs.getString("hotelname"));
					dto.setHoteladdress(rs.getString("hoteladdress"));
					dto.setHotelinfo(rs.getString("hotelinfo"));
					
					dto.setDay1(rs.getString("day1"));
					dto.setDay2(rs.getString("day2"));
					dto.setDay3(rs.getString("day3"));
					dto.setDay4(rs.getString("day4"));
					dto.setDay5(rs.getString("day5"));
					
					dto.setCaution(rs.getString("caution"));
					dto.setAgreement(rs.getString("agreement"));
					dto.setSafeinfo(rs.getString("safeinfo"));
					dto.setInsurunce(rs.getString("insurunce"));
					dto.setHelpphone(rs.getString("helpphone"));
										
					
				}
				
			}catch(SQLException e){
			    	e.printStackTrace();
		    }finally {
			    	DBManager.close(conn, pstmt, rs);
			}
			return dto ;
			  
		}
		
}
		

