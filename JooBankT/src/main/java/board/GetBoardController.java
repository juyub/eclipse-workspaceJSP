package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.CommentDAO;
import comment.CommentVO;
import controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String boardNO = request.getParameter("boardNO");
		
		BoardVO vo = new BoardVO();
		vo.setBoardNO(Integer.parseInt(boardNO));
		BoardDAO dao= new BoardDAO();
		BoardVO board = dao.selectBoardNo(vo);
		
		request.setAttribute("board",board);
		
		CommentDAO dao1= new CommentDAO();
		List<CommentVO> commentList = dao1.getCommentListByBoardNO(Integer.parseInt(boardNO));

	    request.setAttribute("commentList", commentList);
		
		return "/board/getBoard.jsp";
//	    return "redirect:getBoard.do?boardNO=" + boardNO;
	}

}
