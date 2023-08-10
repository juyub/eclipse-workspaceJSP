package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.BoardDAO;
import vo.BoardVO;

public class GetBoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		request.setAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
}