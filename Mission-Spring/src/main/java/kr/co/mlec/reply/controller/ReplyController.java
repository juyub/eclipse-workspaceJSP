package kr.co.mlec.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.reply.service.ReplyService;
import kr.co.mlec.reply.vo.ReplyVO;

@RestController
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply")
	public void addReply(ReplyVO reply) {
		replyService.addReply(reply);
	}
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> getReplyList(@PathVariable("boardNo") int boardNo) {
		
		List<ReplyVO> replyList = replyService.getReplyList(boardNo);
		
		return replyList;
	}
}
















