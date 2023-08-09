package comment;

import java.util.Date;

import org.springframework.stereotype.Component;

/*
   	CREATE TABLE sj_comment (
		commentNO number(10) PRIMARY KEY,
		seq number(10),
		writer VARCHAR2(50),
		CONTENT VARCHAR2(2000),
		regtime TIMESTAMP DEFAULT SYSTIMESTAMP,
		FOREIGN KEY (seq) REFERENCES sj_board(seq)
	);
	
	create sequence seq_tjl_comment_commentNO nocache;
*/

@Component
public class CommentVO {
	
	private int commentNO;
	private int seq;
	private String writer;
	private String content;
	private Date regtime;
	
	public int getCommentNO() {
		return commentNO;
	}
	public void setCommentNO(int commentNO) {
		this.commentNO = commentNO;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	
	@Override
	public String toString() {
		return "CommentVO [commentNO=" + commentNO + ", seq=" + seq + ", writer=" + writer + ", content=" + content
				+ ", regtime=" + regtime + "]";
	}
	
}
