package controller.borrow;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BorrowDAO;
import vo.BookVO;
import vo.BorrowVO;
import vo.UserVO;

public class BorrowBookController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		BookVO book = (BookVO) session.getAttribute("book"); 
		UserVO user = (UserVO) session.getAttribute("user"); 
		
		String bookno = Integer.toString(book.getBookno());
		String userno = Integer.toString(user.getUserno());
		
//		int bookno = book.getBookno();
//		int userno = user.getUserno();
		
//		String bookno = request.getParameter("bookno");
//		String userno = request.getParameter("userno");
		
		BorrowVO vo = new BorrowVO();
		
//		vo.setBookno(bookno);
//		vo.setUserno(userno);
		
		vo.setBookno(book.getBookno());
		vo.setUserno(user.getUserno());
		
//		vo.setBookno(Integer.parseInt(bookno));
//		vo.setUserno(Integer.parseInt(userno));
		
		BorrowDAO dao = new BorrowDAO();
		dao.borrowBook(vo);
		
		return "getBook.do";
	}
	
}
