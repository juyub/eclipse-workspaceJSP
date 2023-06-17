package controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("msg", "로그인 성공");
		
		return "redirect:" + request.getContextPath();
		//return "redirect:/MyBanking";      위의 의미
		//return "redirect:/MyBanking/main.do";  이렇게 활용할수도 있음
		
		//return "/jsp/login/loginProcess.jsp";	//forward
	}

}
