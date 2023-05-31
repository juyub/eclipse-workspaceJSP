package controller.board;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.board.BoardDAO;
import biz.board.BoardVO;
import controller.Controller;

public class InsertBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
//		HttpSession session = request.getSession();
//		UserVO user = (UserVO) session.getAttribute("user"); // 세션에서 user 객체를 가져옵니다
//		String writer = user.getId(); // writer를 ID로 사용하고 싶다면, 이 코드를 사용해 user의 ID를 가져옵니다.
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		dao.insertBoard(vo);
	
		return "Ok.jsp";
	}

}
