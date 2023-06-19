package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.BoardDAO;
import board.BoardVO;
import controller.Controller;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		List boardList = dao.getAllBoard();
		
//		HttpSession session = request.getSession();
//		session.setAttribute("boardList", boardList);
		request.setAttribute("boardList", boardList);
		
		return "/board/boardList.jsp";
	}
	
}
