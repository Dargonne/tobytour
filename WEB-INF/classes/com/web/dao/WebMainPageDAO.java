package com.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.util.DBManager;
import com.web.dto.WebMainPageDTO;

public class WebMainPageDAO {
	private WebMainPageDAO(){}
	
	private static WebMainPageDAO instance = new WebMainPageDAO(); 
	public static WebMainPageDAO getInstance(){
		return instance;
	}
	
	public void setGuestCounter(){
		Connection conn = null; 
		Statement stmt = null; 
		String sql = "insert into counter values(to_char(sysdate, 'yymmdd'), 1)"; 
		
		try{
			conn = DBManager.getConnection(); 
			stmt = conn.createStatement();
			stmt.executeQuery(sql);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt);
		}
		
	}
	
	public List<WebMainPageDTO> getRecentProduct() {
		
		String sql = "select mainproduct_no, productname, productstatement, depday, productimage from mainproductinfo order by mainproduct_no desc";
		
		List<WebMainPageDTO> list = new ArrayList<WebMainPageDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {			
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			
			while (rs.next()) {
				WebMainPageDTO dto = new WebMainPageDTO(); 
				
				dto.setMainProductNo(rs.getString("mainproduct_no"));
				dto.setMainProductName(rs.getString("productname"));
				dto.setMainProductStatement(rs.getString("productstatement"));
				dto.setMainProductDepday(rs.getString("depday"));
				dto.setMainProductImage(rs.getString("productimage"));
								
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
}
