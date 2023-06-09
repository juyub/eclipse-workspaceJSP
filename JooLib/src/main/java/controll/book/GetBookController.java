package controll.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BookDAO;
import dao.BorrowDAO;
import vo.BookVO;
import vo.BorrowVO;
import vo.UserVO;

public class GetBookController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
//		UserVO user = (UserVO) session.getAttribute("user");
		
		String bookno = request.getParameter("bookno");
//		String userno = request.getParameter("userno");
		
		BookVO vo = new BookVO();
		vo.setBookno(Integer.parseInt(bookno));
		
		BookDAO dao = new BookDAO();
		BookVO book = dao.getBook(vo);
		
//		BorrowVO vo1 = new BorrowVO();
//		vo1.setBookno(Integer.parseInt(bookno));
//		vo1.setUserno(user.getUserno());
//		BorrowDAO dao1 = new BorrowDAO();
//		BorrowVO borrow = dao1.getBorrow(vo1);
				
		session.setAttribute("book", book);
//		session.setAttribute("borrow", borrow);
		
//		request.setAttribute("book", book);
		
		return "getBook.jsp";
	}
	
}
