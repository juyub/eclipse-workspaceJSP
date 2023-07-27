package board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardVO boardVO;
	
	@RequestMapping("index")
	public String index(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("boardList", boardList);

	    return "/WEB-INF/view/index.jsp";            
	}

	@RequestMapping("getBoardList")
	public String getBoardList(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("boardList", boardList);

	    return "getBoardList.jsp";            
	}
	
	@RequestMapping("getBoard")
	public String getBoard(String seq, Model model) {
	    BoardVO board = boardDAO.getBorad(seq);
	    model.addAttribute("board", board);
		
	    return "getBoard.jsp";
	}
	
	@RequestMapping("addBoard")
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
		boardDAO.deleteBoard(seq);
		
		return "redirect:/getBoardList";
	}
    
}
