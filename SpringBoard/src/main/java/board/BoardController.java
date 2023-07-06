package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardVO boardVO;
	
	@RequestMapping("index")
	public String index(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("data", boardList);

	    return "/WEB-INF/view/index.jsp";            
	}

	@RequestMapping("getBoardList")
	public String getBoardList(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("data", boardList);

	    return "getBoardList.jsp";            
	}
	
	@RequestMapping("getBoard")
	public String getBoard(String seq, Model model) {

//	    BoardVO vo = this.boardVO;
//	    vo.setSeq(Integer.parseInt(seq));
//	    BoardVO board = boardDAO.getBorad(vo);

	    BoardVO board = boardDAO.getBorad(seq);

	    model.addAttribute("board", board);
		
	    return "getBoard.jsp";
	}
	
}
