package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class GetAccountIDController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String ac_number = request.getParameter("ac_number");
		
		AccountVO vo = new AccountVO();
		vo.setAc_number(Integer.parseInt(ac_number));
		
		AccountDAO dao = new AccountDAO();
		AccountVO account = dao.getAc_number(vo);
		
		request.setAttribute("account", account);
		
		return null;
	}

}
