package controll.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.BookDAO;
import vo.BookVO;

public class DeleteBookController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		String bookno = request.getParameter("bookno");
		
		BookVO vo = new BookVO();
		vo.setBookno(Integer.parseInt(bookno));		
		
		BookDAO dao = new BookDAO();
		dao.deleteBook(vo);
						
		return "getBookList.do";
	}

	
}
