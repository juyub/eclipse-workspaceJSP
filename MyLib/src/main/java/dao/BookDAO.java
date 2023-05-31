package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import vo.BookVO;
import vo.UserVO;

public class BookDAO {

	// 책을 추가하는 메소드
	public void addBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO t_book(no, title, writer, publisher, stock) ");
		sql.append("VALUES(seq_t_book_no.nextval, ?, ?, ?, ?)");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getStock());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책 정보를 수정하는 메소드
	public void updateBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t_book ");
		sql.append("SET title = ?, writer = ?, publisher = ?, stock = ? ");
		sql.append("WHERE no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setInt(5, book.getNo());
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getStock());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 책 정보를 삭제하는 메소드
	public void deleteBook(int no) {
		String sql = "DELETE FROM t_book WHERE no = ?";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, no);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 모든 책 정보를 조회하는 메소드
	public List<BookVO> getAllBooks() {
		List<BookVO> bookList = new ArrayList<>();
		String sql = " SELECT no, title, writer, publisher, " + " CASE " + " WHEN rental = 1 OR stock = 0 THEN '대출불가능' "
				+ " WHEN rental = 0 THEN '대출가능' " + " WHEN rental = 1 THEN '대출중' " + " END AS rental_status "
				+ " FROM t_book ";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setRental(rs.getString("rental_status"));

				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

//    public List<BookVO> getAllBooks() {
//        List<BookVO> bookList = new ArrayList<>();
//        StringBuilder sql = new StringBuilder();
//        sql.append(" SELECT no, title, writer, publisher, ");
//        sql.append("       ,DECODE(rental, 0, '보유중', 1, '대여중') AS rental_status ");
//        sql.append("   FROM t_book; ");
//    /*
//        StringBuilder sql = new StringBuilder();
//        sql.append(" SELECT no, title, writer, publisher, ");
//        sql.append("        DECODE(rental, 0, '대출가능', 1, '대여중') AS rental_status ");
//        sql.append("   FROM t_book ");
//    */
//        
//        try (Connection conn = new ConnectionFactory().getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql./*.toString()*/);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                BookVO book = new BookVO();
//                book.setNo(rs.getInt("no"));
//                book.setTitle(rs.getString("title"));
//                book.setWriter(rs.getString("writer"));
//                book.setPublisher(rs.getString("publisher"));
//
//                bookList.add(book);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return bookList;
//    }

	// 도서 번호 목록
	public BookVO getBookByNO(int no) {
		BookVO book = null;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM t_book ");
		sql.append("WHERE no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setInt(1, no);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					book = new BookVO();
					book.setNo(rs.getInt("no"));
					book.setTitle(rs.getString("title"));
					book.setWriter(rs.getString("writer"));
					book.setPublisher(rs.getString("publisher"));
					book.setRental(rs.getString("rental"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// 도서명 목록
	public BookVO getBookByTitle(String title) {

		List<BookVO> bookList = new ArrayList<>();
		String sql = " SELECT * FROM t_book " +
	                 " WHERE title LIKE '%' || ? || '%' ";
				
		BookVO book = null;
//		StringBuilder sql = new StringBuilder();
//		sql.append("SELECT * FROM t_book ");
//		sql.append("WHERE title = ? "); 

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql/*toString()*/)) {
			pstmt.setString(1, title);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					book = new BookVO();
					book.setNo(rs.getInt("no"));
					book.setTitle(rs.getString("title"));
					book.setWriter(rs.getString("writer"));
					book.setPublisher(rs.getString("publisher"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

//    // rental 값을 입력받아 출력하는
//    public List<BookVO> getBookByRental(String rental) {
//        List<BookVO> bookList = new ArrayList<>();
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM t_book ");
//        sql.append("WHERE rental = ? "); 
//
//        try (Connection conn = new ConnectionFactory().getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
//            pstmt.setString(1, rental); // 수정: rental 값을 바인딩
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    BookVO book = new BookVO();
//                    book.setNo(rs.getInt("no"));
//                    book.setTitle(rs.getString("title"));
//                    book.setWriter(rs.getString("writer"));
//                    book.setPublisher(rs.getString("publisher"));
//                    book.setRental(rs.getString("rental")); 
//                    book.setRented_by(rs.getString("rented_by")); 
//                    book.setRental_date(rs.getDate("rental_date")); 
//                    
//                    bookList.add(book);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return bookList;
//    }

	// rental1 = 1 (대여중)인 도서 목록
	public List<BookVO> getBookByRented() {
		List<BookVO> bookList = new ArrayList<>();
		String sql = " SELECT b.no, b.title, b.writer, b.publisher, b.rental_date, j.name, j.phone " + " FROM t_book b "
				+ " LEFT JOIN t_user j ON b.rented_by = j.no " + " WHERE b.rental = '1' ";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BookVO book = new BookVO();
	            book.setNo(rs.getInt("no"));
	            book.setTitle(rs.getString("title"));
	            book.setWriter(rs.getString("writer"));
	            book.setPublisher(rs.getString("publisher"));
	            book.setRented_by(rs.getString("name")); 
	            book.setRental_date(rs.getDate("rental_date"));
	            
	            UserVO user = new UserVO();
	            user.setPhone(rs.getString("phone"));
	            
	            book.setUser(user);
				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	// rental1 = 0 (대출가능)인 도서 목록
	public List<BookVO> getBookByRental() {
		List<BookVO> bookList = new ArrayList<>();
		String sql = " SELECT no, title, writer, publisher, " +
					" CASE " + " WHEN rental = 1 OR stock = 0 THEN '대출불가능' "
				+ " WHEN rental = 0 THEN '대출가능' " + 
		" WHEN rental = 1 THEN '대출중' " + " END AS rental_status "
				+ " FROM t_book " + " WHERE rental = '0' ";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				BookVO book = new BookVO();
				book.setNo(rs.getInt("no"));
				book.setTitle(rs.getString("title"));
				book.setWriter(rs.getString("writer"));
				book.setPublisher(rs.getString("publisher"));
				book.setRental(rs.getString("rental_status"));

				bookList.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	// 제목, 저자, 출판사로 책이 존재하는지 확인하는 메소드
	public boolean isBookExists(String title, String writer, String publisher) {
		boolean exists = false;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT COUNT(*) FROM t_book ");
		sql.append("WHERE title = ? AND writer = ? AND publisher = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setString(3, publisher);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					int count = rs.getInt(1);
					if (count > 0) {
						exists = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exists;
	}

	// 도서를 대여하는 메소드
	public void rentBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t_book ");
		sql.append("SET rental = '1', rented_by = ?, rental_date = ? ");
		sql.append("WHERE no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setInt(3, book.getNo());
			pstmt.setString(1, book.getRented_by());

			// currentDate 변수를 선언하고 초기화
			java.util.Date currentDate = new java.util.Date();
			pstmt.setDate(2, new java.sql.Date(currentDate.getTime()));

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 도서를 반납하는 메소드
	public void returnBook(BookVO book) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t_book ");
		sql.append("SET rental = '0', rented_by = null, rental_date = null ");
		sql.append("WHERE no = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			pstmt.setInt(1, book.getNo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
