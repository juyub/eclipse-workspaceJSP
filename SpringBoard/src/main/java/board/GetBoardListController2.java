package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.BoardDAO;
import board.BoardVO;
import controller.Controller;

public class GetBoardListController2 implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		request.setAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
}
