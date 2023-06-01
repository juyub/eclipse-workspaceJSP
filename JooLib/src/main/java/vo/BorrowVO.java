package vo;

import java.util.Date;

/*
	CREATE TABLE borrows (
		borrow_no NUMBER(10, 0) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
		user_no NUMBER(10, 0) NOT NULL,
		book_no NUMBER(10, 0) NOT NULL,
		borrow_date DATE NOT NULL,
		due_date DATE NOT NULL,
		return_date DATE,
		FOREIGN KEY (user_no) REFERENCES users(user_no),
		FOREIGN KEY (book_no) REFERENCES books(book_no)
	);
*/

public class BorrowVO {

	private int borrowno;
    private int userno;
    private int bookno;
    private Date borrowdate;
    private Date duedate;
    private Date returndate;
	
}
