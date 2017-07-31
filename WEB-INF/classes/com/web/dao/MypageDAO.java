package com.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.DBManager;
import com.web.dto.MypageDTO;

public class MypageDAO {

	// Singleton 생성
	private MypageDAO() {
	}

	private static MypageDAO instance = new MypageDAO();

	public static MypageDAO getInstance() {
		return instance;
	}

	// 예약내역
	public List<MypageDTO> showReservation(String id) {

		List<MypageDTO> list = new ArrayList<MypageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		String sql = "select M.mainproduct_no as mainproduct_no, P.subproduct_no as subproduct_no, P.seq_purchase as seq_purchase, M.productname as productname , S.startday as startday, ";
				sql += " S.endday as endday, P.traveler as traveler, P.totalcost as totalcost, P.paymentday as paymentday, P.cancelstatus as cancelstatus from ";
				sql += " MainProductInfo M, SubProductInfo S, PurchaseInfo P where M.mainproduct_no=S.mainproduct_no and S.mainproduct_no = P.mainproduct_no ";
				sql += " and id=? order by P.paymentday DESC";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				MypageDTO dto = new MypageDTO();
				dto.setMainproduct_no(rs.getString("mainproduct_no"));
				dto.setSeq_purchase(rs.getString("seq_purchase"));
				dto.setSubproduct_no(rs.getString("subproduct_no"));
				dto.setProductname(rs.getString("productname"));
				dto.setStartday(rs.getTimestamp("startday"));
				dto.setEndday(rs.getTimestamp("endday"));
				dto.setTraveler(rs.getString("traveler"));
				dto.setTotalcost(rs.getInt("totalcost"));
				dto.setPaymentday(rs.getTimestamp("paymentday"));
				dto.setCancelstatus(rs.getInt("cancelstatus"));				

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	// 장바구니 내역
	public List<MypageDTO> showBasket(String id) {

		List<MypageDTO> list = new ArrayList<MypageDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from(select * from basketinfo) B inner join"
				+ " (select * from mainproductinfo) M on B.mainproduct_no = M.mainproduct_no"
				+ " where id=? order by B.seq_basket desc";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MypageDTO dto = new MypageDTO();

				dto.setSeq_basket(rs.getString("seq_basket"));
				dto.setBasketMainSeq(rs.getString("mainproduct_no"));
				dto.setBasketSubSeq(rs.getString("subproduct_no"));
				dto.setProductname(rs.getString("productname"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	//예약 취소
	public boolean cancelReservation(String id, String mainProduct, String seq_purchase) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean cancle_check=false;
		String sql = "UPDATE purchaseinfo SET cancelstatus=1 WHERE ID=? and mainproduct_no=? and seq_purchase=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, mainProduct);
			pstmt.setString(3, seq_purchase);
			pstmt.executeUpdate();
			cancle_check=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return cancle_check;
	}
	
	//예약 취소 과정을 위한 금액 가져오기
	public int cancelReservationCost(String id, String mainProduct, String seq_purchase) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cancelCost=0;
		String sql = "select totalcost from purchaseinfo where id=? and mainproduct_no=? and seq_purchase=?";

			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, mainProduct);
				pstmt.setString(3, seq_purchase);
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					cancelCost = rs.getInt("totalcost");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
			return cancelCost;
		}
	
	//수량 조절
	public boolean changeProductLeast(int count, String subNo, String mainNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean change_check=false;
		String sql = "update subproductinfo set productleast = productleast+? where subproduct_no=? and mainproduct_no=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, count);
			pstmt.setString(2, subNo);
			pstmt.setString(3, mainNo);
			pstmt.executeUpdate();
			change_check=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return change_check;
	}
	//장바구니 삭제
	public void deleteBasket(String id, String seq_basket) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete basketinfo where seq_basket=? and id=?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq_basket);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public String getPurchaseTraveler(String id, String mainSeq, String subSeq, String purSeq){
		String returnTraveler = null; 
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		String sql = "select traveler from purchaseinfo where id=? and mainproduct_no=? and subproduct_no=? and seq_purchase=?";
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, mainSeq);
			pstmt.setString(3, subSeq);
			pstmt.setString(4, purSeq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				returnTraveler = rs.getString("traveler");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return returnTraveler; 
	}
	
	public void minusSalesCost(int cost){
		
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
