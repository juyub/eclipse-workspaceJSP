package controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		//System.out.println("LogoutController handleRequest() 호출...");
	
		return "/jsp/login/logout.jsp";
	}

}
