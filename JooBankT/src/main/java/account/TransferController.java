package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class TransferController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String sourceAccountNumber = request.getParameter("source_account_number");
        String targetAccountNumber = request.getParameter("target_account_number");
        double transferAmount = Double.parseDouble(request.getParameter("transfer_amount"));
        String transactionDetailName = request.getParameter("transaction_detail_name");

        AccountDAO accountDAO = new AccountDAO();
        boolean isSuccess = accountDAO.transferMoney(sourceAccountNumber, targetAccountNumber, transferAmount, transactionDetailName);

        if (isSuccess) {
            request.setAttribute("message", "Transfer successful!");
        } else {
            request.setAttribute("message", "Transfer failed!");
        }

		return "result.jsp";
	}

}
