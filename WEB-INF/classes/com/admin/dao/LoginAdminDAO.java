package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.admin.dto.LoginAdminDTO;
import com.util.DBManager;

public class LoginAdminDAO {
	
	private LoginAdminDAO(){}
	
	private static LoginAdminDAO instance = new LoginAdminDAO(); 
	public static LoginAdminDAO getInstance(){
		return instance;
	}
	
	
	// 로그인을 위한 아이디 / 비밀번호 확인 처리
	public int validateID(LoginAdminDTO dto){
		
		int count = 0; 
		// SQL문 실행 
		String sql = "select name from memberinfo where id=? and password=? and usersection=1"; 
		
		// Connection 객체 초기화
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAdminID());
			pstmt.setString(2, dto.getAdminPassword());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
					count = 1; 
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return count;
		
	}
	
	public boolean checkIDList(){
		
		boolean flag = false; 
		// SQL문 실행 
		String sql = "select * from memberinfo"; 
		
		// Connection 객체 초기화
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("회원정보 불러오기");
			if(rs.next()){
					flag = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return flag;
		
	}
	
	public boolean installComplete(){
		
		boolean flag = false; 
		// SQL문 실행 
		String sql = "insert into memberinfo values('admin','1234','管理者',to_char(sysdate,'yyyyMMdd'),0,'TOBYTOUR','07012345678',0,null,sysdate,sysdate,1)"; 
		
		// Connection 객체 초기화
		Connection conn = null; 
		Statement stmt = null; 
		
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("관리자ID 생성완료");
			flag = true;
			
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt);
		}
		
		return flag;
		
	}
}
