package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBManager;
import com.web.dto.BasketAddDTO;

public class BasketAddDAO {
	private BasketAddDAO(){}
	
	private static BasketAddDAO instance = new BasketAddDAO(); 
	public static BasketAddDAO getInstance(){
		return instance;
	}
	
	// 장바구니 등록 
	public boolean insertBasket(BasketAddDTO dto){
		
		boolean flag = false; 
		// SQL QUERY 문
		String sql = "insert into basketinfo values(?,?,?,0,?)"; 
						
		// Connection 객체 초기화 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
				
		//DB 처리 
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1, dto.getBasketSeq());
			pstmt.setString(2, dto.getBasketMainSeq());
			pstmt.setString(3, dto.getBasketSubSeq());
			pstmt.setString(4, dto.getBasketID());
			pstmt.executeUpdate();
			flag = true; 				
		}catch(SQLException e){
			e.printStackTrace();			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
			return flag; 	
	}
			
	public String getRecentBasketNum(){
		String sql = "select * from (select seq_basket from basketinfo order by seq_basket desc) where rownum = 1"; 
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
				getSeqNumber = rs.getString("seq_basket"); 
			}
					
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}				
				
		return getSeqNumber;
	}
}
