package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestBoardController {

	@Autowired
	private BoardDAO boardDAO;

	@GetMapping("api/getBoardList")
	public ResponseEntity<List<BoardVO>> getBoardList() {
		List<BoardVO> boardList = boardDAO.getBoardList();
		return ResponseEntity.ok(boardList);
	}

	@GetMapping("api/getBoard/{seq}")
	public ResponseEntity<BoardVO> getBoard(@PathVariable String seq) {
		BoardVO board = boardDAO.getBorad(seq);
		return ResponseEntity.ok(board);
	}

    @PostMapping("api/addBoard")
    public ResponseEntity<Void> addBoard(BoardVO vo) {
        boardDAO.addBoard(vo);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("api/updateBoard")
    public ResponseEntity<Void> updateBoard(BoardVO vo) {
    	boardDAO.updateBoard(vo);
    	return ResponseEntity.ok().build();
    }

    @DeleteMapping("api/deleteBoard")
    public ResponseEntity<Void> deleteBoard(String seq) {
        boardDAO.deleteBoard(seq);
        return ResponseEntity.ok().build();
    }
	
}
