package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBManager;
import com.web.dto.PurchaseDTO;

public class PurchaseDAO {
	private PurchaseDAO(){}
	
	private static PurchaseDAO instance = new PurchaseDAO(); 
	public static PurchaseDAO getInstance(){
		return instance;
	}
	
	public PurchaseDTO getPurchaseChoice(String subSeq){
		String sql = "select M.productname, S.*  from MainProductInfo M, SubProductInfo S where M.mainproduct_no=S.mainproduct_no and S.subproduct_no=?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PurchaseDTO dto = new PurchaseDTO(); 
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subSeq);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setSelectProductName(rs.getString("productname"));
				dto.setSelectSubSeq(rs.getString("subproduct_no"));
				dto.setSelectMainSeq(rs.getString("mainproduct_no"));
				dto.setSelectStartDay(rs.getDate("startday"));
				dto.setSelectEndDay(rs.getDate("endday"));
				dto.setSelectAirline(rs.getString("airline"));
				dto.setSelectCost(rs.getInt("cost"));
				dto.setSelectOilCost(rs.getInt("oilcost"));
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}				
				
		return dto;
	}
	
	public PurchaseDTO getPurchaseUser(String userID){
		String sql = "select id, name, phone from memberinfo where id=?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PurchaseDTO dto = new PurchaseDTO(); 
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setPurchaseID(rs.getString("id")); 
				dto.setPurchaseName(rs.getString("name"));
				dto.setPurchasePhone(rs.getString("phone"));
				
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}				
				
		return dto;
	}
	
	
	public String getPurchaseNum(){
		String sql = "select * from (select seq_purchase from purchaseinfo order by  seq_purchase desc) where rownum = 1"; 
		String getSeqNumber = null;
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rs = null;
				
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
							
			while(rs.next()){
				getSeqNumber = rs.getString("seq_purchase"); 
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}				
				
		return getSeqNumber;
	}
	
	public int getPurchaseLeast(String mainSeq, String subSeq){
		String sql = "select productleast from subproductinfo where sellstatus=0 and subproduct_no=? and mainproduct_no=?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int productLeast = 0; 
		
		// DB 접근 및 Select문 처리
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subSeq);
			pstmt.setString(2, mainSeq);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				productLeast = rs.getInt("productleast"); 
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}				
				
		return productLeast;
	}
	
	public boolean insertPurchaseInfo(PurchaseDTO dto) {
		boolean flag = false; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into purchaseinfo values(?,?,?,?,?,' ',0,?,?,0,sysdate,0)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPurchaseSeq());
			pstmt.setString(2, dto.getPurchaseMainSeq());
			pstmt.setString(3, dto.getPurchaseSubSeq());
			pstmt.setString(4, dto.getPurchaseID());
			pstmt.setString(5, dto.getPurchaseTraveler());
			pstmt.setInt(6, dto.getPurchaseTotalCost());
			pstmt.setInt(7, dto.getPurchasePaymentMeasure());
			pstmt.executeUpdate();
			
			flag = true; 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		return flag;
	}
	
	public void changeProductLeast(int count, String subNo, String mainNo){
		
	       	Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update subproductinfo set productleast = productleast-? where subproduct_no=? and mainproduct_no=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, count);
				pstmt.setString(2, subNo);
				pstmt.setString(3, mainNo);
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
	}
	
	public void addSalesCost(int cost){
		
       	Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into salesinfo values(to_char(sysdate,'yymmdd'),?)";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cost);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
}
	
	
}
