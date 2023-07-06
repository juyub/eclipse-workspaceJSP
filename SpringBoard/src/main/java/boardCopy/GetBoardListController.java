package boardCopy;

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
public class GetBoardListController {

	@Autowired
	private BoardDAO boardDAO;

//    public void setBoardDAO(BoardDAO boardDAO) {
//        this.boardDAO = boardDAO;
//    }

	@RequestMapping("/index")
	public String index(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("data", boardList);

	    return "/WEB-INF/view/index.jsp";            
	}

	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
	    List<BoardVO> boardList = boardDAO.getBoardList();
	    model.addAttribute("data", boardList);

	    return "getBoardList.jsp";            
	}
	
////	@RequestMapping("/getBoardList")
//	@RequestMapping("/index")
//	public String index(Model model) {
//		List<BoardVO> boardList = boardDAO.getBoardList();
//		model.addAttribute("data", boardList);
//		
////		 return "getBoardList.jsp";
//		return "/WEB-INF/view/index.jsp";				
//	}
	
//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	// 게시글 목록을 가져오기 위해 DAO 메서드 호출
//        List<BoardVO> boardList = boardDAO.getBoardList();
//
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("data", boardList); // 게시글 목록 데이터를 뷰에 전달
//        mv.setViewName("/getBoardList.jsp");  // 게시글 목록을 표시하는 JSP를 지정합니다.
//
//        return mv;
//    }
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		BoardVO vo = new BoardVO();
//		BoardDAO dao = new BoardDAO();
//		List<BoardVO> boardList = dao.getBoardList(vo);
//		
////		System.out.println(boardList);
//		
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("data", boardList);
//		mv.setViewName("/getBoardList.jsp");
//		
//		return mv;
//	}
	
   
}