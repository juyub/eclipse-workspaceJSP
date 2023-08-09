package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.BoardDAO;
import vo.BoardVO;

public class SearchBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String writer = request.getParameter("writer");
		
		BoardVO vo = new BoardVO();
		vo.setWriter(writer);
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.searchBoard(vo);
		
		request.setAttribute("boardList", boardList);
				
		return "getBoardList.jsp";
	}

}
