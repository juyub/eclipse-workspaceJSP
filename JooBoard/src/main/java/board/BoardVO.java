package board;

import java.util.Date;

import org.springframework.stereotype.Component;

/*
	CREATE TABLE sj_board (
		seq NUMBER(10) PRIMARY KEY,
		parentSeq NUMBER(10) DEFAULT 0,
		writer VARCHAR2(50),
		title VARCHAR2(200),
		CONTENT VARCHAR2(2000),
		regDate TIMESTAMP DEFAULT SYSTIMESTAMP,
		hit NUMBER(10, 0) DEFAULT 0
	);
	
	create sequence seq_sj_board_seq nocache;
 */

@Component
public class BoardVO {
	
	private int level;
	private int seq;
	private int parentSeq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private Integer hit;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getParentSeq() {
		return parentSeq;
	}
	public void setParentSeq(int parentSeq) {
		this.parentSeq = parentSeq;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "BoardVO [level=" + level + ", seq=" + seq + ", parentSeq=" + parentSeq + ", title=" + title
				+ ", writer=" + writer + ", content=" + content + ", regDate=" + regDate + ", hit=" + hit + "]";
	}
	
}
