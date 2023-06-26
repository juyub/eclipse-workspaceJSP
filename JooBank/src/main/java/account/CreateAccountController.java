package account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class CreateAccountController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String AC_PW = request.getParameter("AC_PW");
		int pd_number = Integer.parseInt(request.getParameter("pd_number"));
		
		AccountVO vo = new AccountVO();
		vo.setId(id);
		vo.setAC_PW(AC_PW);
		vo.setPD_NUMBER(pd_number);
		
		AccountDAO dao = new AccountDAO();
		dao.createAccount(vo);
		
		return "myAccountList.do";
	}

}
