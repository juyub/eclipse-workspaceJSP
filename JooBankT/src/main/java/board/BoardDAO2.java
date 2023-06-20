package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JDBCUtil;

public class BoardDAO2 {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// 모든 게시글 조회
	public List getAllBoard() {
		List boardList = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			String query = " SELECT LEVEL,boardNO,parentNO,title,content,memberNO,REGDATE " 
			             + " from jb_board "
					     + " START WITH  parentNO=0 " + " CONNECT BY PRIOR boardNO=parentNO "
					     + " ORDER SIBLINGS BY boardNO DESC ";
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int boardNO = rs.getInt("boardNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				int memberNO = rs.getInt("memberNO");
				Date regdate = rs.getDate("REGDATE");
				BoardVO board = new BoardVO();
				board.setLevel(level);
				board.setBoardNO(boardNO);
				board.setParentNO(parentNO);
				board.setTitle(title);
				board.setContent(content);
				board.setMemberNO(memberNO);
				board.setRegdate(regdate);
				boardList.add(board);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	// 게시글 추가
	public void addBoard(BoardVO vo) {
	    try {
	        conn = JDBCUtil.getConnection();
	        
	        // getNewArticleNO() 메서드를 여기에 정의하고 사용
	        int boardNO = 0;
	        String boardNOQuery = " SELECT jb_board_seq.NEXTVAL FROM DUAL ";
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
	        int memberNO = vo.getMemberNO();
	        
	        String query = 
	        		" INSERT INTO jb_board (boardNO, parentNO, title, content, memberNO) "
	                + " VALUES (?, ? ,?, ?, ?) ";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, boardNO);
	        stmt.setInt(2, parentNO);
	        stmt.setString(3, title);
	        stmt.setString(4, content);
	        stmt.setInt(5, memberNO);
	        stmt.executeUpdate();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// 게시판 번호로 검색
	public BoardVO selectBoardNo(BoardVO vo){
		BoardVO board=new BoardVO();
		try{
		conn = JDBCUtil.getConnection();
		String query =
				" select boardNO,parentNO,title,content, memberNO, REGDATE " +
			    " from jb_board " + " where boardNO=? ";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, vo.getBoardNO());
		ResultSet rs =stmt.executeQuery();
		rs.next();
		int boardNO2 = rs.getInt("boardNO");
		int parentNO=rs.getInt("parentNO");
		String title = rs.getString("title");
		String content =rs.getString("content");
		int memberNO = rs.getInt("memberNO");
		Date regdate = rs.getDate("REGDATE");

		board.setBoardNO(boardNO2);
		board.setParentNO (parentNO);
		board.setTitle(title);
		board.setContent(content);
		board.setMemberNO(memberNO);
		board.setRegdate(regdate);
		rs.close();
		stmt.close();
		conn.close();
		}catch(Exception e){
		e.printStackTrace();	
		}
		return board;
		}
	
	// 게시글 수정
	public void updateBoard(BoardVO vo) {
		int boardNO = vo.getBoardNO();
		String title = vo.getTitle();
		String content = vo.getContent();
		try {
			conn = JDBCUtil.getConnection();
			String query = " update jb_board set title=?, content=? " +
						   " where boardNO=? ";
			
			stmt = conn.prepareStatement(query);
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setInt(3, boardNO);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 게시글 삭제
	public void deleteBoard(int boardNO) {
		try {
			conn = JDBCUtil.getConnection();
			String query = 
					" DELETE FROM jb_board " +
						 " WHERE boardNO in ( " +
											" SELECT boardNO FROM  jb_board " +
											" START WITH boardNO = ? " +
											" CONNECT BY PRIOR  boardNO = parentNO ) ";
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, boardNO);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> selectRemovedArticles(int  articleNO) {
		List<Integer> articleNOList = new ArrayList<Integer>();
		try {
			conn = JDBCUtil.getConnection();
			String query = "SELECT articleNO FROM  t_board  ";
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR  articleNO = parentNO";
			System.out.println(query);
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, articleNO);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				articleNO = rs.getInt("articleNO");
				articleNOList.add(articleNO);
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNOList;
	}
	
	// 답글 생성
	public void addReply(BoardVO vo) {
	    try {
	        conn = JDBCUtil.getConnection();

	        // 원 게시물의 boardNO 가져오기
	        int parentNO = vo.getParentNO();

	        // getNewArticleNO() 메서드를 여기에 정의하고 사용
	        int boardNO = 0;
	        String boardNOQuery = " SELECT jb_board_seq.NEXTVAL FROM DUAL ";
	        stmt = conn.prepareStatement(boardNOQuery);
	        ResultSet rs = stmt.executeQuery(boardNOQuery);
	        if (rs.next()) {
	            boardNO = rs.getInt(1)+1;
	        }
	        rs.close();
	        stmt.close();
	        
	        String title = vo.getTitle();
	        String content = vo.getContent();
	        int memberNO = vo.getMemberNO();
	        
	        String query = 
	                " INSERT INTO jb_board (boardNO, parentNO, title, content, memberNO) "
	                + " VALUES (?, ? ,?, ?, ?) ";
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, boardNO);
	        stmt.setInt(2, parentNO); // 원 게시물 부모 번호 설정
	        stmt.setString(3, title);
	        stmt.setString(4, content);
	        stmt.setInt(5, memberNO);
	        stmt.executeUpdate();
	        stmt.close();
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
}
	

