package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBManager;
import com.web.dto.RegisterDTO;

public class RegisterDAO {
	
	private RegisterDAO(){}
	
	private static RegisterDAO instance = new RegisterDAO(); 
	public static RegisterDAO getInstance(){
		return instance;
	}
	
	// 새로운 공지사항 등록
	public void insertMember(RegisterDTO dto){

	// Query문 선언 
	String sql = "INSERT INTO MEMBERINFO VALUES(?,?,?,?,?,?,?,?,null,sysdate,sysdate, 0)";
			
	// Connection 객체 생성
	Connection conn = null; 
	PreparedStatement pstmt = null; 
			
	// DB문 실행
	try{
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql); 
		pstmt.setString(1, dto.getUserID());
		pstmt.setString(2, dto.getUserPassword());
		pstmt.setString(3, dto.getUserName());
		pstmt.setString(4, dto.getUserBirth());
		pstmt.setInt(5, dto.getUserSex());
		pstmt.setString(6, dto.getUserAddress());
		pstmt.setString(7, dto.getUserPhone());
		pstmt.setInt(8, dto.getUserEmailReceive());
		pstmt.executeUpdate();
		System.out.println("회원가입 완료");
	}catch(SQLException e){
		e.printStackTrace();			
	}finally {
		DBManager.close(conn, pstmt);
	}
			
	}
	
	// 중복된 아이디인지 처리
	public boolean validateID(String id){
		
		boolean flag = true; 
		// SQL문 실행 
		String sql = "select * from memberinfo where id=?"; 
		
		// Connection 객체 초기화
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null; 
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				flag = false; 
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return flag;
		
	}
	
	public void addJoinMemberCount(){

		// Query문 선언 
		String sql = "insert into memberjoininfo values(to_char(sysdate,'yymmdd'), 1)";
			
		// Connection 객체 생성
		Connection conn = null; 
		Statement stmt = null; 
			
		// DB문 실행
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
}
