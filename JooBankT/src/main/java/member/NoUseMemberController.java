package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class NoUseMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberVO login = (MemberVO) session.getAttribute("login");
		
		MemberVO vo = new MemberVO();
		vo.setMemberNO(login.getMemberNO());
		vo.setMemberID(login.getMemberID());
		vo.setPassword(login.getPassword());
		vo.setName(login.getName());
		vo.setPhone(login.getPhone());
		MemberDAO dao = new MemberDAO();
		dao.noUse(vo);
		
		session.invalidate();
		
		return "index.jsp";
	}

}
