package controll.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BookDAO;
import vo.BookVO;

public class GetBookController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		String bookno = request.getParameter("bookno");
		BookVO vo = new BookVO();
		vo.setBookno(Integer.parseInt(bookno));
		
		BookDAO dao = new BookDAO();
		BookVO book = dao.getBook(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		
//		request.setAttribute("book", book);
		
		return "getBook.jsp";
	}
	
}
