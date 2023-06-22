package page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDAO;
import account.AccountVO;
import controller.Controller;

public class TransferPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String accountID = request.getParameter("accountID");
		
		AccountVO vo = new AccountVO();
		vo.setAccountID(Integer.parseInt(accountID));
		
		AccountDAO dao = new AccountDAO();
		AccountVO account = dao.getAccountID(vo);
		
		request.setAttribute("account", account);
		
		return "/account/transfer.jsp";
	}

}
