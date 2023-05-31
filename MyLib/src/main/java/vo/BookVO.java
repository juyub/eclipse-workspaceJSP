package vo;

import java.sql.Date;

/*
CREATE TABLE t_book (
      no            NUMBER(5)       PRIMARY KEY
    , title         VARCHAR2(200)   NOT NULL
    , writer        VARCHAR2(100)   NOT NULL
    , publisher     VARCHAR2(200)   NOT NULL
    , stock         NUMBER(5)       DEFAULT 0
    , rental        VARCHAR2(12)    DEFAULT 0
    , rented_by		VARCHAR2(12)    DEFAULT 0
    , rental_date   DATE
);
 */

public class BookVO {
	
	private int no;
	private String title;
	private String writer;
	private String publisher;
	private int stock;
	private String rental;
	private String rented_by;
	private Date rental_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getRental() {
		return rental;
	}
	public void setRental(String rental) {
		this.rental = rental;
	}
	public String getRented_by() {
		return rented_by;
	}
	public void setRented_by(String rented_by) {
		this.rented_by = rented_by;
	}
	public Date getRental_date() {
		return rental_date;
	}
	public void setRental_date(Date rental_date) {
		this.rental_date = rental_date;
	}
	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher + ", stock="
				+ stock + ", rental=" + rental + ", rented_by=" + rented_by + ", rental_date=" + rental_date + "]";
	}
	public BookVO(int no, String title, String writer, String publisher, int stock, String rental, String rented_by,
			Date rental_date) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.stock = stock;
		this.rental = rental;
		this.rented_by = rented_by;
		this.rental_date = rental_date;
	}
	public BookVO() {
		super();
	}
	
    private UserVO user; // UserVO 객체를 참조하는 필드

    // UserVO 객체를 설정하는 메소드
    public void setUser(UserVO user) {
        this.user = user;
    }

    // UserVO 객체를 반환하는 메소드
    public UserVO getUser() {
        return user;
    }
	
	
}