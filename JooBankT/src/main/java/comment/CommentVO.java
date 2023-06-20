package comment;

import java.util.Date;

/*
	CREATE TABLE jb_comment (
		commentNO number(10) PRIMARY KEY,
		boardNO number(10),
		memberNO NUMBER(10, 0),
		CONTENT VARCHAR2(2000),
		REGDATE DATE DEFAULT CURRENT_DATE,
		FOREIGN KEY (memberNO) REFERENCES jb_member(memberNO),
		FOREIGN KEY (boardNO) REFERENCES jb_board(boardNO)
	);
	
	CREATE SEQUENCE jb_comment_seq
	START WITH 1
	INCREMENT BY 1
	NOCACHE;
 */

public class CommentVO {
	
	private int commentNO;
	private int boardNO;
	private int memberNO;
	private String content;
	private Date regdate;
	
	private String memberID;
	private String name;
	
	public int getCommentNO() {
		return commentNO;
	}
	public void setCommentNO(int commentNO) {
		this.commentNO = commentNO;
	}
	public int getBoardNO() {
		return boardNO;
	}
	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}
	public int getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
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
