package board;

import java.util.Date;

/*
	CREATE TABLE jb_board (
		boardNO number(10) PRIMARY KEY,
		parentNO number(10) default 0,
		memberNO NUMBER(10, 0),
		TITLE VARCHAR2(200),
		CONTENT VARCHAR2(2000),
		REGDATE DATE DEFAULT CURRENT_DATE,
		hit NUMBER(10, 0),
		FOREIGN KEY (memberNO) REFERENCES jb_member(memberNO)
	);
	
	CREATE SEQUENCE jb_board_seq
	START WITH 6
	INCREMENT BY 1
	NOCACHE;	
 */

public class BoardVO {

	private int level;
	private int boardNO;
	private int parentNO;
	private int memberNO;
	private String title;
	private String content;
	private Date regdate;
	
	private String memberID;
	private String name;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getBoardNO() {
		return boardNO;
	}
	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}
	public int getParentNO() {
		return parentNO;
	}
	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}
	public int getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
