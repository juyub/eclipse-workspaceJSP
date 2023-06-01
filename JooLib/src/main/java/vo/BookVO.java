package vo;

/*
	CREATE TABLE books (
	    book_no NUMBER(10, 0) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	    title VARCHAR2(255) NOT NULL,
	    author VARCHAR2(255) NOT NULL,
	    publisher VARCHAR2(255),
	    publication_year NUMBER(4, 0),
	    isbn VARCHAR2(13) UNIQUE,
	    category VARCHAR2(255),
	    total_n NUMBER(10, 0),
	    available_n NUMBER(10, 0)
	);
*/

public class BookVO {

	private int bookno;
    private String title;
    private String author;
    private String publisher;
    private int publicationyear;
    private String isbn;
    private String category;
    private int totaln;
    private int availablen;
	
}
