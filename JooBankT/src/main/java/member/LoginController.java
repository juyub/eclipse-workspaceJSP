package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import member.MemberDAO;
import member.MemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		MemberVO vo = new MemberVO();
		vo.setMemberID(id);
		vo.setPassword(password);

		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.getMember(vo);

		if (member != null) {
			HttpSession session = request.getSession();
//			HttpSession session2 = request.getSession();
//			session.setAttribute("user", user);
			session.setAttribute("login", member);
			request.setAttribute("member", member);
			return "index.jsp";
		} else {
			request.setAttribute("loginFailed", true);
			return "JooBankTT/login/login.jsp";
		}

	}
}
