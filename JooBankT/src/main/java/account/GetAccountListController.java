package account;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import member.MemberVO;

public class GetAccountListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("login");
		
		AccountVO vo = new AccountVO();
		vo.setMemberNO(member.getMemberNO());
		
		AccountDAO dao = new AccountDAO();
		List<AccountVO> accountList = dao.myAccountList(vo);
		
		request.setAttribute("accountList", accountList);
				
		return "/account/accountMain.jsp";
	}

}
