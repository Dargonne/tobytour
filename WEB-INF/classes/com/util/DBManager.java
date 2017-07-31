package com.util;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/** 
 * Connection Pool 
 * */ 

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource; // Connection 연결해서 동작하려고 함. 

public class DBManager {
	
	// Connection 객체를 얻기 위한 메서드 
	public static Connection getConnection(){
				
		Context initContext;
		Connection conn = null; 
		
		try{
			initContext = new InitialContext();
			Context envContext  = (Context) initContext.lookup("java:/comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/myoracle");
			conn = dataSource.getConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return conn; 
	}
	
	// Select를 수행한 후 리소스 해제를 위한 메서드(단일 쿼리)
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
			conn.close();
			stmt.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// insert update delete를 수행한 후 리소스 해제를 위한 메서드(단일 쿼리) 
	public static void close(Connection conn, Statement stmt){
		try {
			conn.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// insert update delete를 수행한 후 리소스 해제를 위한 메서드(동적 쿼리)
	public static void close(Connection conn, PreparedStatement pstmt){
		try {
			conn.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	// select를 수행한 후 리소스 해제를 위한 메서드(동적 쿼리)
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
		try{
			conn.close();
			pstmt.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
