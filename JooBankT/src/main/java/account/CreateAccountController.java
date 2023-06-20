package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class CreateAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String memberNO = request.getParameter("memberNO");
		String accountPassword = request.getParameter("accountPassword");
		
		AccountVO vo = new AccountVO();
		vo.setMemberNO(Integer.parseInt(memberNO));
		vo.setAccountPassword(Integer.parseInt(accountPassword));
		
		AccountDAO dao = new AccountDAO();
		dao.createAccount(vo);
		
		return "/account/accountMain.jsp";
	}

}
