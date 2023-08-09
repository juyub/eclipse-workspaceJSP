package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class RestBoardController {

	@Autowired
	private BoardDAO boardDAO;
	
	@GetMapping("api/getBoardList")
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = boardDAO.getBoardList();
		return boardList;
	}

	@GetMapping("api/getBoard/{seq}")
	public BoardVO getBoard(@PathVariable String seq) {
		BoardVO board = boardDAO.getBorad(seq);
		return board;
	}

    @PostMapping("api/addBoard")
    public void addBoard(BoardVO vo) {
        boardDAO.addBoard(vo);
        return;
    }
    
    @PutMapping("api/updateBoard")
    public void updateBoard(BoardVO vo) {
    	boardDAO.updateBoard(vo);
    	return;
    }

    @DeleteMapping("api/deleteBoard/{seq}")
    public void deleteBoard(@PathVariable String seq) {
        boardDAO.deleteBoard(seq);
        return;
    }
    
//	@Autowired
//	private RestBoardDAO restBoardDAO;
//	
//	@GetMapping("api/getBoardListRest")
//	public String getBoardListRest(Model model) throws JsonMappingException, JsonProcessingException {
//		List<BoardVO> boardList = restBoardDAO.getBoardList();
//		model.addAttribute("boardList", boardList);
//		return "getBoardList.jsp";
//	}
    
//    @GetMapping("api/getBoardList")
//    public ResponseEntity<List<BoardVO>> getBoardList() {
//    	List<BoardVO> boardList = boardDAO.getBoardList();
//    	return ResponseEntity.ok(boardList);
//    }
//    
//    @GetMapping("api/getBoard/{seq}")
//    public ResponseEntity<BoardVO> getBoard(@PathVariable String seq) {
//    	BoardVO board = boardDAO.getBorad(seq);
//    	return ResponseEntity.ok(board);
//    }
//    
//    @PostMapping("api/addBoard ")
//    public ResponseEntity<Void> addBoard(BoardVO vo) {
//    	boardDAO.addBoard(vo);
//    	return ResponseEntity.ok().build();
//    }
//    
//    @PutMapping("api/updateBoard")
//    public ResponseEntity<Void> updateBoard(BoardVO vo) {
//    	boardDAO.updateBoard(vo);
//    	return ResponseEntity.ok().build();
//    }
//    
//    @DeleteMapping("api/deleteBoard")
//    public ResponseEntity<Void> deleteBoard(String seq) {
//    	boardDAO.deleteBoard(seq);
//    	return ResponseEntity.ok().build();
//    }
	
}
