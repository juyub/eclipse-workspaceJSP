package controller;

import java.util.HashMap;
import java.util.Map;

import controll.book.AddBookController;
import controll.book.GetBookListController;
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
//		mappings.put("/getBoard.do", new GetBoardController());
//		mappings.put("/updateBoard.do", new UpdateBoardController());
//		mappings.put("/deleteBoard.do", new DeleteBoardController());
//		mappings.put("/searchBoard.do", new SearchBoardController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
	
}
