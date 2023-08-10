package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.BoardDAO;
import vo.BoardVO;

public class UpdateBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String seq = request.getParameter("seq");
		String content = request.getParameter("content");
		String hit = request.getParameter("hit");
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setSeq(Integer.parseInt(seq));
		vo.setHit(Integer.parseInt(hit));
		
		BoardDAO dao = new BoardDAO();
		dao.updateBoard(vo);
		
		return "getBoardList.do";
	}

	
}