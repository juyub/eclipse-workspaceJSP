package kr.co.mlec.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

//@Controller
public class MemberController2 {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, HttpSession session) {

		MemberVO userVO = memberService.login(member);
		if(userVO == null) {
			// 로그인 실패
			return "login/login";
		}
		// 로그인 성공
		session.setAttribute("userVO", userVO);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
}










