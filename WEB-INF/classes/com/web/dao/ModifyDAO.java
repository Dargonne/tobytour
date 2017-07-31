package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBManager;
import com.web.dto.ModifyDTO;

public class ModifyDAO {

	// Singleton 생성
	private ModifyDAO() {
	}

	private static ModifyDAO instance = new ModifyDAO();

	public static ModifyDAO getInstance() {
		return instance;
	}

	// 비밀번호 확인
	public ModifyDTO checkPass(String id) {
		ModifyDTO dto = new ModifyDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from memberinfo where id=?";
		String pass = "";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				dto.setPass(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setBirth(rs.getString("birth"));
				if (rs.getInt("sex") == 1)
					dto.setSex("남");
				else
					dto.setSex("여");
				dto.setAddress(rs.getString("address"));
				dto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return dto;
	}

	// 수정사항 업데이트
	public void modifyUpdate(String id, String address, String phone, int emailrecieve) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBERINFO SET ADDRESS=?, PHONE=?, EMAILRECIEVE=? WHERE ID=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setString(2, phone);
			pstmt.setInt(3, emailrecieve);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	// 비밀번호 업데이트
	public void modifyUpdatePass(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBERINFO SET password=? WHERE ID=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
