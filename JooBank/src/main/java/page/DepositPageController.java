package page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDAO;
import account.AccountVO;
import controller.Controller;

public class DepositPageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String ac_number = request.getParameter("ac_number");
		
//		AccountVO vo = new AccountVO();
//		vo.setAc_number(Integer.parseInt(ac_number));
		
		AccountDAO dao = new AccountDAO();
//		AccountVO account = dao.getAc_number(vo);
		AccountVO account = dao.getAccount(Integer.parseInt(ac_number));
		
		request.setAttribute("account", account);
		
		return "/account/deposit.jsp";
	}

}
