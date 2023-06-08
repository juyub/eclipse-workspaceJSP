package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BorrowDAO;
import dao.UserDAO;
import vo.BorrowVO;
import vo.UserVO;

public class DeleteUserController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userno = request.getParameter("userno");
		UserVO user = (UserVO) session.getAttribute("user");
		
		UserVO vo = new UserVO();
		vo.setUserno(Integer.parseInt(userno));
		vo.setUserno(user.getUserno());
		UserDAO dao = new UserDAO();

		BorrowVO vo1 = new BorrowVO();
//		vo1.setUserno(Integer.parseInt(userno));
		vo1.setUserno(user.getUserno());
		BorrowDAO dao1 = new BorrowDAO();
		List<BorrowVO> borrowUser = dao1.getBorrowingUser(vo1);

		if (borrowUser.isEmpty()) {
			dao.deleteUser(vo);

			session.invalidate();

			return "indexPage.do";
		} else {
			return "getUserNo.do";
		}

	}

}
