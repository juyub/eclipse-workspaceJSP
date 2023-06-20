package member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import member.MemberDAO;
import member.MemberVO;

public class JoinController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		vo.setMemberID(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		dao.addMember(vo);
		
		return "index.jsp";
	}

}
