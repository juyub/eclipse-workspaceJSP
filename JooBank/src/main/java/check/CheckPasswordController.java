package check;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.AccountDAO;
import controller.Controller;

public class CheckPasswordController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int ac_number = Integer.parseInt(request.getParameter("sendAc_number"));
        String AC_PW = request.getParameter("AC_PW");

        AccountDAO accountDao = new AccountDAO();
        boolean isPasswordCorrect = accountDao.checkAC_PW(ac_number, AC_PW);

        response.setContentType("text/plain");
        try {
            response.getWriter().print(isPasswordCorrect);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
	}

}
