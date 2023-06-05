package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import vo.BookVO;
import vo.BorrowVO;

public class BorrowDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 대출 정보 추가 메서드
	public void borrowBook(BorrowVO vo) {
	    insertBorrowInfo(vo);
	    updateBookAvailablen(vo);
	    updateUserBorrown(vo);
	}

	// 대출 정보를 추가하는 메서드
	private void insertBorrowInfo(BorrowVO vo) {
	    String query = "INSERT INTO borrows (userno, bookno, borrowdate, duedate) " +
	            "VALUES (?, ?, SYSDATE, SYSDATE + 7)";

	    try (Connection conn = JDBCUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setInt(1, vo.getUserno());
	        pstmt.setInt(2, vo.getBookno());

	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	// 도서 재고를 -1 메서드
	private void updateBookAvailablen(BorrowVO vo) {
	    String query = "UPDATE books SET availablen = availablen - 1 WHERE bookno = ?";

	    try (Connection conn = JDBCUtil.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query)) {

	        pstmt.setInt(1, vo.getBookno());

	        pstmt.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// 대출 가능 권수 -1 메서드
	private void updateUserBorrown(BorrowVO vo) {
		String query = "UPDATE users SET borrown = borrown - 1 WHERE userno = ?";
		
		try (Connection conn = JDBCUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			
			pstmt.setInt(1, vo.getUserno());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
    // 대출 정보 조회(전체 또는 특정 조건) 메서드
	public List<BorrowVO> getBorrowList(BorrowVO vo) {
		List<BorrowVO> borrowList = new ArrayList<BorrowVO>();
		String query = 
				" SELECT b.borrowno, u.userid AS username, bo.title, b.borrowdate, b.duedate, b.returndate\r\n "
			  + " FROM borrows b\r\n "
			  + " JOIN users u ON b.userno = u.userno\r\n "
			  + " JOIN books bo ON b.bookno = bo.bookno ";
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BorrowVO borrow = new BorrowVO();
				borrow.setBorrowno(rs.getInt("borrowno"));
				borrow.setUsername(rs.getString("username"));
	            borrow.setTitle(rs.getString("title"));
				borrow.setBorrowdate(rs.getDate("borrowdate"));
				borrow.setDuedate(rs.getDate("duedate"));
				borrow.setReturndate(rs.getDate("returndate"));
				borrowList.add(borrow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return borrowList;
	}

    // 대출 정보 수정 메서드

    // 대출 정보 삭제 메서드
	
}
