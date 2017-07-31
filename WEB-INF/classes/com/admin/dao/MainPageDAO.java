package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.admin.dto.MainPageDTO;
import com.util.DBManager;

public class MainPageDAO {

	// Singleton 생성
	private MainPageDAO() {
	}

	private static MainPageDAO instance = new MainPageDAO();

	public static MainPageDAO getInstance() {
		return instance;
	}

	
	
	// 공지사항 목록 보이기
	public List<MainPageDTO> showNoticeArticle() {

		// Query 선언
		String sql = "select seq_notice, title, noticedate from Notice order by seq_notice desc";

		// DTO List 및 Connection 초기화
		List<MainPageDTO> list = new ArrayList<MainPageDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MainPageDTO dto = new MainPageDTO();
				dto.setNoticeSeq(rs.getString("seq_notice"));
				dto.setNoticeTitle(rs.getString("title"));
				dto.setNoticeWriteDate(rs.getTimestamp("noticedate"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	//문의사항 목록 보이기
	public List<MainPageDTO> requestNoticeArticle() {

		// Query 선언
		String sql = "SELECT SEQ_FAQ, TITLE, WRITEDATE FROM FAQ order by seq_faq desc";

		// DTO List 및 Connection 초기화
		List<MainPageDTO> list = new ArrayList<MainPageDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MainPageDTO dto = new MainPageDTO();
				dto.setRequestSeq(rs.getString("seq_faq"));
				dto.setRequestTitle(rs.getString("title"));
				dto.setRequestWriteDate(rs.getTimestamp("writedate"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	//메모장 정보 가지고 오기
	public String showMemoInfo() {

		// Query 선언
		String sql = "select * from adminmemo";

		// DTO List 및 Connection 초기화
		String memoContent = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MainPageDTO dto = new MainPageDTO();
				dto.setMemoContent(rs.getString("Content"));
				memoContent=dto.getMemoContent();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return memoContent;
	}
	
	//금일 스케쥴 보기
	public List<MainPageDTO> showTodaySchedule() {

		// Query 선언
		String sql = "SELECT * from todayschedule where tododate=to_date(sysdate,'yy/MM/dd')";

		// DTO List 및 Connection 초기화
		List<MainPageDTO> list = new ArrayList<MainPageDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MainPageDTO dto = new MainPageDTO();
				dto.setTododate(rs.getTimestamp("tododate"));
				dto.setTodolist(rs.getString("todolist"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	//선택 날짜 스케쥴 입력
		public int insertSelectDaySchedule(String selectDay, String daySchedule) {
			// Query 선언
			String sql = "insert into todayschedule values(to_date(?,'yy/MM/dd'), ?)";
			
			int check=0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, selectDay);
				pstmt.setString(2, daySchedule);
				pstmt.executeQuery();
				check=1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return check;
		}
		
	//1주일간 가입자수 얻어오기
	public int getMember() {

		// Query 선언
		String sql = "select count(*) as count from memberinfo where joindate >= sysdate-7 and joindate <= sysdate";

		// DTO List 및 Connection 초기화
		int getMember = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				getMember = rs.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return getMember;
		}
		
	//1주일간 가입자수 얻어오기
	public int getVisitor() {

		// Query 선언
		String sql = "select count(*) as count from counter where visitday >= sysdate-7 and visitday <= sysdate";

		// DTO List 및 Connection 초기화
		int getVisitor = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
			getVisitor = rs.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
			return getVisitor;
	}
	
	//1주일간 주문건수 얻어오기
	public int getOrder() {

		// Query 선언
		String sql = "select count(*) as count from purchaseinfo where paymentday >= sysdate-7 and paymentday <= sysdate";

		// DTO List 및 Connection 초기화
		int getOrder = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		// DB 접근 및 Select문 처리
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				getOrder = rs.getInt("count");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
			return getOrder;
	}
	
	//1주일간 주문건수 얻어오기
	public int getSales() {

			// Query 선언
			String sql = "select sum(totalcost) as total from purchaseinfo where paymentday >= sysdate-7 and paymentday <= sysdate";

			// DTO List 및 Connection 초기화
			int getSales = 0;
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;

			// DB 접근 및 Select문 처리
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					getSales = rs.getInt("total");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, stmt, rs);
			}
				return getSales;
		}
		
			
	
	// 메모 수정
	public void updateMemoContent(String content) {

		// SQL QUERY 문
		String sql = "UPDATE adminmemo SET content=?";

		// Connection 객체 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;

		// DB 처리
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, content);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	// 선택한 스케쥴 보기 
		public MainPageDTO showChoiceTodaySchedule(String todolist){
			
			// SQL문 실행 
			String sql = "select * from todayschedule where todolist=?"; 
			
			// Connection 객체 초기화
			MainPageDTO dto = new MainPageDTO(); 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			ResultSet rs = null; 
			
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, todolist);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					dto.setTododate(rs.getTimestamp("tododate"));
					dto.setTodolist(rs.getString("todolist"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			} finally{
				DBManager.close(conn, pstmt, rs);
			}
			return dto;
		}
		
		// 스케쥴 삭제 
		public void deleteSchedule(String todolist){
			
			//SQL 문 생성 
			String sql = "DELETE todayschedule WHERE todolist=?"; 
			
			//Connection 객체 초기화 
			Connection conn = null; 
			PreparedStatement pstmt = null; 
			
			//DB 처리 
			try{
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, todolist);
				pstmt.executeUpdate(); 
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		//스케쥴 수정
		public int updateDaySchedule(String selectDay, String daySchedule) {
			// Query 선언
			String sql = "update todayschedule set tododate=(to_date(?,'yy/MM/dd')), todolist=?";
			
			int check=0;
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, selectDay);
				pstmt.setString(2, daySchedule);
				pstmt.executeQuery();
				check=1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return check;
		}
		
		public void addAdminMemo() {

			
			// Query 선언
			String sql = "insert into adminmemo values('여기에 메모를 입력하세요')";

			// DTO List 및 Connection 초기화
			Connection conn = null;
			Statement stmt = null;

			// DB 접근 및 Select문 처리
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, stmt);
				
			}
			
		}
}
