package controller;

import java.util.HashMap;
import java.util.Map;

import board.GetBoardListController;
import member.JoinController;
import member.LoginController;
import member.LogoutController;

public class HandlerMapping {

	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/join.do", new JoinController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
//		mappings.put("/getUserList.do", new GetUserListController());
//		mappings.put("/getUserNo.do", new GetUserNoController());
//		mappings.put("/updateUser.do", new UpdateUserController());
//		mappings.put("/deleteUser.do", new DeleteUserController());
//		mappings.put("/getUserMy.do", new GetUserMyController());
//		mappings.put("/searchUser.do", new SearchUserController());
//		
		mappings.put("/getBoardList.do", new GetBoardListController());
		
//		mappings.put("/addBook.do", new AddBookController());
//		mappings.put("/getBookList.do", new GetBookListController());
//		mappings.put("/getBook.do", new GetBookController());
//		mappings.put("/searchBook.do", new SearchBookController());
//		mappings.put("/deleteBook.do", new DeleteBookController());
//		mappings.put("/updateBook.do", new UpdateBookController());
//		
//		mappings.put("/borrowBook.do", new BorrowBookController());
//		mappings.put("/getBorrowList.do", new GetBorrowListController());
//		mappings.put("/getBorrowUser.do", new GetBorrowUserController());
//		mappings.put("/returnBook.do", new ReturnBookController());
//		
//		mappings.put("/loginPage.do", new LoginPageController());
//		mappings.put("/indexPage.do", new IndexPageController());
//		mappings.put("/addUserPage.do", new AddUserPageController());
//		mappings.put("/goUserListPage.do", new GoUserListPageController());
//		mappings.put("/goGetBookPage.do", new GoGetBookPageController());
//		mappings.put("/goBorrowListPage.do", new GoBorrowListPageController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
