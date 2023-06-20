package comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class UpdateCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String commentNO = request.getParameter("commentNO");
		String content = request.getParameter("content");
		
		CommentVO vo = new CommentVO();
		vo.setCommentNO(Integer.parseInt(commentNO));
		vo.setContent(content);
		
		CommentDAO dao = new CommentDAO();
		dao.updateComment(vo);
		
		return "/board/getBoard.jsp";
	}

}
