package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.UserDAO;
import vo.UserVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		UserVO vo = new UserVO();
		vo.setUserid(id);
		vo.setPassword(password);

		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);

		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "index.jsp";
		} else {
			return "login.jsp";
		}

	}

}
