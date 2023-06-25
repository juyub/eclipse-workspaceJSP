package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 모든 게시글 조회
	public List<BoardVO> selectAllBoard(int pageNo, int pageSize) {
		int start = (pageNo - 1) * pageSize + 1;
		int end = pageNo * pageSize;

		List<BoardVO> boardList = new ArrayList<BoardVO>();
		String query = " SELECT * " + " FROM ( "
				+ " SELECT LEVEL, boardNO, parentNO, title, content, REGtime, id, hit, ROWNUM AS rnum "
				+ " FROM jb_board " + " START WITH parentNO = 0 " + " CONNECT BY PRIOR boardNO = parentNO "
				+ " ORDER SIBLINGS BY boardNO DESC " + " ) " + " WHERE rnum BETWEEN ? AND ? ";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int boardNO = rs.getInt("boardNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Timestamp regtime = rs.getTimestamp("regtime");
				int hit = rs.getInt("hit");

				BoardVO board = new BoardVO();
				board.setLevel(level);
				board.setBoardNO(boardNO);
				board.setParentNO(parentNO);
				board.setTitle(title);
				board.setContent(content);
				board.setId(id);
				board.setRegtime(regtime);
				board.setHit(hit);

				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}

	public int selectBoardCount() {
		int count = 0;
		String query = "SELECT COUNT(*) AS count FROM jb_board";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return count;
	}

	// 게시글 추가
	public void addBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();

			// getNewArticleNO() 메서드를 여기에 정의하고 사용
			int boardNO = 0;
			String boardNOQuery = " SELECT seq_boardno.NEXTVAL FROM DUAL ";
			stmt = conn.prepareStatement(boardNOQuery);
			ResultSet rs = stmt.executeQuery(boardNOQuery);
			if (rs.next()) {
				boardNO = rs.getInt(1) + 1;
			}
			rs.close();
			stmt.close();

			int parentNO = 0;
			String title = vo.getTitle();
			String content = vo.getContent();
			String id = vo.getId();

			String query = " INSERT INTO jb_board (boardNO, parentNO, title, content, id) "
					+ " VALUES (?, ? ,?, ?, ?) ";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNO);
			stmt.setInt(2, parentNO);
			stmt.setString(3, title);
			stmt.setString(4, content);
			stmt.setString(5, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}

	// 게시판 번호로 getBoard
	public BoardVO selectBoardNo(BoardVO vo) {
		BoardVO board = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			String query = " SELECT boardNO, parentNO, title, content, id, regtime " + " FROM jb_board "
					+ " WHERE boardNO = ? ";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, vo.getBoardNO());
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int boardNO = rs.getInt("boardNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String id = rs.getString("id");
			Timestamp regtime = rs.getTimestamp("regtime");

			board.setBoardNO(boardNO);
			board.setParentNO(parentNO);
			board.setTitle(title);
			board.setContent(content);
			board.setId(id);
			board.setRegtime(regtime);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}

	// 업데이트 메소드 추가
	public void updateHit(int boardNO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = JDBCUtil.getConnection();
			String query = "UPDATE jb_board SET hit = hit + 1 WHERE boardNO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNO);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}

	// 답글 등록
	public void addReply(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();

			// 원 게시물의 boardNO 가져오기
			int parentNO = vo.getParentNO();

			// getNewArticleNO() 메서드를 여기에 정의하고 사용
			int boardNO = 0;
			String boardNOQuery = " SELECT seq_boardno.NEXTVAL FROM DUAL ";
			stmt = conn.prepareStatement(boardNOQuery);
			ResultSet rs = stmt.executeQuery(boardNOQuery);
			if (rs.next()) {
				boardNO = rs.getInt(1) + 1;
			}
			rs.close();
			stmt.close();

			String title = vo.getTitle();
			String content = vo.getContent();
			String id = vo.getId();

			String query = " INSERT INTO jb_board (boardNO, parentNO, title, content, id) "
					+ " VALUES (?, ? ,?, ?, ?) ";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNO);
			stmt.setInt(2, parentNO); // 원 게시물 부모 번호 설정
			stmt.setString(3, title);
			stmt.setString(4, content);
			stmt.setString(5, id);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}

	}

	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub

	}

	public void deleteBoard(int parseInt) {
		// TODO Auto-generated method stub

	}

}
