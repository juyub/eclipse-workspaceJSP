package comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import board.BoardVO;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	private CommentVO commentVO;

	@RequestMapping("getCommentList")
	public String getCommentList(String seq, Model model) {
		
		List<CommentVO> commentList = commentDAO.getCommentListByBoardNO(seq);
		model.addAttribute("commentList", commentList);
		
		return "redirect:getBoard?seq=" + seq;				
	} 
	
	@RequestMapping("addComment")
	public String addComment(CommentVO vo) {
		commentDAO.addComment(vo);

		return "redirect:getBoard?seq=" + vo.getSeq();
	}
	
	@RequestMapping("updateComment")
	public String updateComment(CommentVO vo) {
		commentDAO.updateComment(vo);

		return "redirect:getBoard?seq=" + vo.getSeq();
	}

	@RequestMapping("deleteComment")
	public String deleteComment(CommentVO vo) {
		commentDAO.deleteComment(vo);

		return "redirect:getBoard?seq=" + vo.getSeq();
	}
	
}
