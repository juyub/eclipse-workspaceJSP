package controller;

import java.util.HashMap;
import java.util.Map;

import controll.book.AddBookController;
import controll.book.DeleteBookController;
import controll.book.GetBookController;
import controll.book.GetBookListController;
import controll.book.SearchBookController;
import controll.book.UpdateBookController;
import controller.borrow.BorrowBookController;
import controller.borrow.GetBorrowListController;
import controller.borrow.GetBorrowUserController;
import controller.borrow.ReturnBookController;
import controller.page.AddUserPageController;
import controller.page.GoUserListPageController;
import controller.page.IndexPageController;
import controller.page.LoginPageController;
import controller.user.AddUserController;
import controller.user.DeleteUserController;
import controller.user.GetUserListController;
import controller.user.GetUserMyController;
import controller.user.GetUserNoController;
import controller.user.LoginController;
import controller.user.LogoutController;
import controller.user.SearchUserController;
import controller.user.UpdateUserController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/addUser.do", new AddUserController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/getUserList.do", new GetUserListController());
		mappings.put("/getUserNo.do", new GetUserNoController());
		mappings.put("/updateUser.do", new UpdateUserController());
		mappings.put("/deleteUser.do", new DeleteUserController());
		mappings.put("/getUserMy.do", new GetUserMyController());
		mappings.put("/searchUser.do", new SearchUserController());
		
		mappings.put("/addBook.do", new AddBookController());
		mappings.put("/getBookList.do", new GetBookListController());
		mappings.put("/getBook.do", new GetBookController());
		mappings.put("/searchBook.do", new SearchBookController());
		mappings.put("/deleteBook.do", new DeleteBookController());
		mappings.put("/updateBook.do", new UpdateBookController());
		
		mappings.put("/borrowBook.do", new BorrowBookController());
		mappings.put("/getBorrowList.do", new GetBorrowListController());
		mappings.put("/getBorrowUser.do", new GetBorrowUserController());
		mappings.put("/returnBook.do", new ReturnBookController());
		
		mappings.put("/loginPage.do", new LoginPageController());
		mappings.put("/indexPage.do", new IndexPageController());
		mappings.put("/addUserPage.do", new AddUserPageController());
		mappings.put("/goUserListPage.do", new GoUserListPageController());
//		mappings.put("/goGetBookPage.do", new GoGetBookPageController());
//		mappings.put("/goBorrowListPage.do", new GoBorrowListPageController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
