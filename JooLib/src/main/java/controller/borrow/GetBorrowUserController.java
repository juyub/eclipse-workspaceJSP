package controller.borrow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BorrowDAO;
import vo.BorrowVO;

public class GetBorrowUserController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String userno = request.getParameter("userno");
		
		BorrowVO vo = new BorrowVO();
		vo.setUserno(Integer.parseInt(userno));
		BorrowDAO dao = new BorrowDAO();
		List<BorrowVO> borrowList = dao.getBorrowUserNo(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("borrowList", borrowList);
		
		return "getUserNo.jsp";
	}

	
}
