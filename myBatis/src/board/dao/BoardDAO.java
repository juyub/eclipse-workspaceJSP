package board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;


public class BoardDAO {

	private SqlSession session;
	
	public BoardDAO() {
		session = new MyConfig().getInstance();
	}
	
	public void insert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("VO로 삽입");
		board.setWriter("hong");
		
		int cnt = session.insert("board.dao.BoardDAO.insert", board);
		session.commit();
		System.out.println("총 " + cnt + "개 행 삽입...");
	}
	
	public void select() {
		// 전체게시글 조회
//		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll");
		List<BoardVO> list = session.selectList("board.dao.BoardDAO.selectAll2");
				
		for(BoardVO board : list ) {
			System.out.println(board);
		}
	}
	
	public void selectOne() {
	
		int boardNo = 4;
		BoardVO result = session.selectOne("board.dao.BoardDAO.selectByNo", boardNo);
		System.out.println(result);
		
		BoardVO board = new BoardVO();
		board.setNo(4);
		result = session.selectOne("board.dao.BoardDAO.selectByNo2", board);
		System.out.println(result);
	}
	
	public void selectWhere() {
		
		/*
		// 1. 제목이 될까??? 이면서 글쓴이가 홍길동인 게시물 조회
		BoardVO board = new BoardVO();
		board.setTitle("될까???");
		board.setWriter("홍길동");
		*/
		
		/*
		// 2. 글쓴이가 홍길동인 게시물 조회
		BoardVO board = new BoardVO();
		board.setWriter("홍길동");
		*/
		
		/*
		// 3. 제목이 될까??? 검색
		BoardVO board = new BoardVO();
		board.setTitle("될까???");
		*/
		// 4. 제목, 작성자 없는경우
		BoardVO board = new BoardVO();
		
		List<BoardVO> list 
		  = session.selectList("board.dao.BoardDAO.selectWhere", board);
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void selectWhere2() {
		// 제목이 될까???, 작성자 홍길동인 게시물 조회
		
		Map<String, String> board = new HashMap<>();
		board.put("title", "될까???");
		board.put("writer", "홍길동");
		
		List<BoardVO> list 
		  = session.selectList("board.dao.BoardDAO.selectWhere2", board);
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void selectWhere3() {
		Map<String, String> board = new HashMap<>();
		board.put("no", "4");
		
		Map<String, Object> result 
		  = session.selectOne("board.dao.BoardDAO.selectWhere3", board);
		
		Set<String> keys = result.keySet();
		for(String key : keys) {
			System.out.println("key : " + key 
					+ ", value : " + result.get(key));
		}
	}
	
	public void selectNos() {
		int[] nos = {1, 2, 4, 5, 7, 10, 20, 21, 22};
		
		List<BoardVO> list 
		   = session.selectList("board.dao.BoardDAO.selectNos", nos);
		
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void work() {
		selectNos();
//		selectWhere3();
//		selectWhere2();
//		selectWhere();
//		selectOne();
//		select();
//		insert();
	}
}






