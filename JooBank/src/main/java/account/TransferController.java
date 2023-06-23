package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int sourceAccountID = Integer.parseInt(request.getParameter("sourceAccountID"));
        int targetAccountID = Integer.parseInt(request.getParameter("targetAccountID"));
        int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));

        AccountDAO accountDAO = new AccountDAO();
        int result = accountDAO.transfer(sourceAccountID, targetAccountID, transferAmount);

        if (result > 0) {
            request.setAttribute("message", "Transfer successful!");
        } else {
            request.setAttribute("message", "Transfer failed!");
        }

        return "redirect:/JooBankT/myAccountList.do";
    }

}
