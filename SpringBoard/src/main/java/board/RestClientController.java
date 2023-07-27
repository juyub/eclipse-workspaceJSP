package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class RestClientController {

	@Autowired
	private RestBoardDAO restBoardDAO;
	
	@GetMapping("getBoardListRest")
	public String getBoardListRest(Model model) throws JsonMappingException, JsonProcessingException {
		List<BoardVO> boardList = restBoardDAO.getBoardList();
		model.addAttribute("boardList", boardList);
		System.out.println("restClinet" + boardList);
		return "getRestBoardList.jsp";
	}
	
}
