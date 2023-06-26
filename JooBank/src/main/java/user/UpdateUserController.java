package user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;


public class UpdateUserController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String borrown = request.getParameter("borrown");
		String role = request.getParameter("role");
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setPhone(phone);
		
		UserDAO dao = new UserDAO();
		dao.updateUser(vo);
		
		return "getUserNo.do";
		
	}
}
