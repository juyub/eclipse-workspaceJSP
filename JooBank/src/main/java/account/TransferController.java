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
        String sendBank_cd = request.getParameter("sendBank_cd");
        String receivBank_cd = request.getParameter("receivBank_cd");
        String rc_text = request.getParameter("rc_text");

        AccountDAO accountDAO = new AccountDAO();
        int result = accountDAO.transfer(sendAc_number, sendBank_cd, receivAc_number, receivBank_cd, transferAmount,rc_text);

        if (result > 0) {
            request.setAttribute("message", "Transfer successful!");
        } else {
            request.setAttribute("message", "Transfer failed!");
        }

        return "redirect:/JooBank/myAccountList.do";
    }

}
