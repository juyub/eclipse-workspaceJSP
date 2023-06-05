package controller;

import java.util.HashMap;
import java.util.Map;

import controll.book.AddBookController;
import controll.book.GetBookController;
import controll.book.GetBookListController;
import controll.book.SearchBookController;
import controller.borrow.BorrowBookController;
import controller.borrow.GetBorrowListController;
import controller.page.GetBookListPageController;
import controller.page.IndexPageController;
import controller.page.LoginPageController;
import controller.user.AddUserController;
import controller.user.LoginController;
import controller.user.LogoutController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/addUser.do", new AddUserController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		
		mappings.put("/addBook.do", new AddBookController());
		mappings.put("/getBookList.do", new GetBookListController());
		mappings.put("/getBook.do", new GetBookController());
		mappings.put("/searchBook.do", new SearchBookController());
		
		mappings.put("/borrowBook.do", new BorrowBookController());
		mappings.put("/getBorrowList.do", new GetBorrowListController());
		
//		mappings.put("/updateBoard.do", new UpdateBoardController());
//		mappings.put("/deleteBoard.do", new DeleteBoardController());
		
		mappings.put("/loginPage.do", new LoginPageController());
		mappings.put("/indexPage.do", new IndexPageController());
		mappings.put("/getBookListPage.do", new GetBookListPageController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
