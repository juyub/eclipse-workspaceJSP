package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.UserDAO;
import vo.UserVO;

public class DeleteUserController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String userno = request.getParameter("userno");
		
		UserVO vo = new UserVO();
		vo.setUserno(Integer.parseInt(userno));		
		
		UserDAO dao = new UserDAO();
		dao.deleteUser(vo);
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "indexPage.do";
	
	}
	
}
