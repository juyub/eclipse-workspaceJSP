package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class DepositController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int accountID = Integer.parseInt(request.getParameter("accountID"));
        double depositAmount = Double.parseDouble(request.getParameter("depositAmount"));

        AccountDAO dao = new AccountDAO();
        int result = dao.deposit(accountID, depositAmount);

        if(result > 0) {
            return "redirect:/JooBankT/myAccountList.do";
        } else {
            // 입금 처리 중 오류가 발생한 경우 적절한 에러 메시지를 사용자에게 보여줍니다.
            request.setAttribute("errorMessage", "입금 처리 중 오류가 발생했습니다. 다시 시도해 주세요.");
            return "/error.jsp";
        }
	}

}
