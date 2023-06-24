package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int sendAc_number = Integer.parseInt(request.getParameter("sendAc_number"));
        int receivAc_number = Integer.parseInt(request.getParameter("receivAc_number"));
        int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));

        AccountDAO accountDAO = new AccountDAO();
        int result = accountDAO.transfer(sendAc_number, receivAc_number, transferAmount);

        if (result > 0) {
            request.setAttribute("message", "Transfer successful!");
        } else {
            request.setAttribute("message", "Transfer failed!");
        }

        return "redirect:/JooBank/myAccountList.do";
    }

}
