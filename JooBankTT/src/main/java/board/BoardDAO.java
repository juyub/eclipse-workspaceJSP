package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import common.JDBCUtil;

public class BoardDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List getAllBoard() {
		List boardList = new ArrayList();
		try {
			conn = JDBCUtil.getConnection();
			String query = "SELECT LEVEL,boardNO,parentNO,title,content,memberNO,REGDATE" 
			             + " from jb_board"
					     + " START WITH  parentNO=0" + " CONNECT BY PRIOR boardNO=parentNO"
					     + " ORDER SIBLINGS BY boardNO DESC";
			System.out.println(query);
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
	
}
