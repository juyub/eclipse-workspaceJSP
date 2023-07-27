package kr.co.mlec;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/*.xml"})
public class BoardService테스트 {

	@Autowired
	private BoardService service;

	@Test
	public void 상세게시글조회테스트() throws Exception {
		BoardVO board = service.getBoardByNo(22);
		System.out.println(board);
	}
}









