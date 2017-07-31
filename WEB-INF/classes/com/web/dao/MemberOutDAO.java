package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBManager;

public class MemberOutDAO {
	private MemberOutDAO() {
	}

	private static MemberOutDAO instance = new MemberOutDAO();

	public static MemberOutDAO getInstance() {
		return instance;
	}
	
	
	public boolean checkID(String id, String password){
		boolean flag = false; 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		String sql = "select * from memberinfo where id=? and password=?"; 
		try{
			conn = DBManager.getConnection(); 
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				flag = true; 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally { 
			DBManager.close(conn, pstmt, rs);
		}
		
		return flag; 
	}
	
	
	public void deleteMember(String id, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete memberinfo where id=? and password=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
