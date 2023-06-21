package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class GetAccountIDController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String accountID = request.getParameter("accountId");
		
		AccountVO vo = new AccountVO();
		vo.setAccountID(Integer.parseInt(accountID));
		
		AccountDAO dao = new AccountDAO();
		AccountVO account = dao.getAccountID(vo);
		
		request.setAttribute("account", account);
		
		return null;
	}

}
