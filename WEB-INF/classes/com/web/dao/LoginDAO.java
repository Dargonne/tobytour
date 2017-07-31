package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBManager;
import com.web.dto.LoginDTO;

public class LoginDAO {

	// Singleton 생성
	private LoginDAO() {
	}

	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	// 로그인
	public LoginDTO loginSubmit(String id) {
		LoginDTO dto = new LoginDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select usersection, id, password from memberinfo where id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("password"));
				dto.setUserSection(rs.getInt("usersection"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}

	// 아이디찾기
	public String search_id(String name, String phone, String birth) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select id from memberinfo where name=? and phone=? and birth=?";
		String id = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, birth);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getString("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}

	// 비밀번호 찾기
	public String search_pass(String id, String phone, String birth) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select password from memberinfo where id=? and phone=? and birth=?";
		String pass = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, phone);
			pstmt.setString(3, birth);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pass = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pass;
	}
	
	// 임시 비밀번호 업데이트
		public String update_pass(String id, String random_pass) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update memberinfo set password=? where id=?";
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, random_pass);
				pstmt.setString(2, id);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return random_pass;
		}
}
