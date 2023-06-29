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
		String sendBank_cd = request.getParameter("sendBank_cd");
		String transferAmount = request.getParameter("transferAmount");
		int receivAc_number = Integer.parseInt(request.getParameter("receivAc_number"));
		String selected_bank_cd = request.getParameter("selected_bank_cd");
		String rc_text = request.getParameter("rc_text");
		
		AccountDAO dao = new AccountDAO();
		
		AccountVO account = dao.getAccount(receivAc_number, selected_bank_cd);
		
		request.setAttribute("account", account);
		request.setAttribute("transferAmount", transferAmount);
		request.setAttribute("sendAc_number", sendAc_number);
		request.setAttribute("sendBank_cd", sendBank_cd);
		request.setAttribute("rc_text", rc_text);
		
		return "/account/transferConfirm.jsp";
	}

}
