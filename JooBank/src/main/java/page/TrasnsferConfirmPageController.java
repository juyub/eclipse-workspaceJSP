package page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDAO;
import account.AccountVO;
import controller.Controller;

public class TrasnsferConfirmPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String sendAc_number = request.getParameter("sendAc_number");
		String transferAmount = request.getParameter("transferAmount");
		int receivAc_number = Integer.parseInt(request.getParameter("receivAc_number"));
		
		AccountDAO dao = new AccountDAO();
		AccountVO account = dao.getAccount(receivAc_number);
		
		request.setAttribute("account", account);
		request.setAttribute("transferAmount", transferAmount);
		request.setAttribute("sendAc_number", sendAc_number);
		
		return "/account/transferConfirm.jsp";
	}

}
