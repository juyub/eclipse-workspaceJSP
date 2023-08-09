package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comment.CommentDAO;
import comment.CommentVO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO boardDAO;

	@Autowired
	private BoardVO boardVO;
	
	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	private CommentVO commentVO;

	@RequestMapping("index")
	public String index(Model model) {
		return "index.jsp";
	}

	@GetMapping("getBoardList")
	public String getBoardList(@RequestParam(defaultValue = "1") int pageNumber, Model model) {
		List<BoardVO> boardList = boardDAO.getBoardList(pageNumber);
		int totalPage = boardDAO.getTotalPage();

		model.addAttribute("boardList", boardList);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalPage", totalPage);

		return "board/getBoardList.jsp";
	}

	@RequestMapping("getBoard")
	public String getBoard(String seq, Model model) {
		BoardVO board = boardDAO.getBorad(seq);
		model.addAttribute("board", board);
		
		List<CommentVO> commentList = commentDAO.getCommentListByBoardNO(seq);
		model.addAttribute("commentList", commentList);

		return "board/getBoard.jsp";
	}

	@RequestMapping("addBoard")
	public String addBoardPage(Model model) {
		return "board/addBoard.jsp";
	}
	
	@RequestMapping("board/addBoard")
	public String addBoard(BoardVO vo) {
		boardDAO.addBoard(vo);

		return "redirect:/getBoardList";
	}

	@RequestMapping("updateBoard")
	public String updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);

		return "redirect:getBoard?seq=" + vo.getSeq();
	}

	@RequestMapping("deleteBoard")
	public String deleteBoard(String seq) {
		boardDAO.deleteComment(seq);
		boardDAO.deleteBoard(seq);

		return "redirect:/getBoardList";
	}
	
	@RequestMapping("addReply")
	public String addReply(BoardVO vo) {
		boardDAO.addReply(vo);

		return "redirect:/getBoardList";
	}

}
