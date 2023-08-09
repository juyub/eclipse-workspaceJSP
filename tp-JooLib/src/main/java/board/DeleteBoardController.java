package board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.BoardDAO;
import vo.BoardVO;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String seq = request.getParameter("seq");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));		
		
		BoardDAO dao = new BoardDAO();
		dao.deleteBoard(vo);
		
		return "getBoardList.do";
	}

}
