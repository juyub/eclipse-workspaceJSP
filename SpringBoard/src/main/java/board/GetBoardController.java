package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.BoardDAO;
import board.BoardVO;

@Controller
public class GetBoardController {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardVO boardVO;

//	public void setBoardDAO(BoardDAO boardDAO) {
//	    this.boardDAO = boardDAO;
//	}

//	public void setBoardVO(BoardVO boardVO) {
//	    this.boardVO = boardVO;
//	}

	@RequestMapping("/getBoard")
	public String getBoard(HttpServletRequest request, Model model) {
	    String seq = request.getParameter("seq");

	    BoardVO vo = this.boardVO;
	    vo.setSeq(Integer.parseInt(seq));

	    BoardVO board = boardDAO.getBorad(vo);

	    model.addAttribute("board", board);
		
	    return "getBoard.jsp";
	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//	    String seq = request.getParameter("seq");
//
//	    BoardVO vo = this.boardVO;
//	    vo.setSeq(Integer.parseInt(seq));
//
//	    BoardVO board = boardDAO.getBorad(vo);
//
//	    ModelAndView mv = new ModelAndView();
//	    mv.addObject("board", board);
//	    mv.setViewName("/getBoard.jsp");
//
//	    return mv;
//	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String seq = request.getParameter("seq");
//		BoardVO vo = new BoardVO();
//		vo.setSeq(Integer.parseInt(seq));
//		
//		BoardDAO dao = new BoardDAO();
//		BoardVO board = dao.getBorad(vo);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("board", board);
//		mv.setViewName("/getBoard.jsp");
//		
//		return mv;
//	}
	
}
