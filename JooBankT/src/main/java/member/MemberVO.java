package member;

import java.util.Date;

/*
	CREATE TABLE jb_member (
		memberNO NUMBER(10, 0) PRIMARY KEY,
		memberID VARCHAR2(255) NOT NULL UNIQUE,
		password VARCHAR2(255) NOT NULL,
		name VARCHAR2(255) NOT NULL,
		phone VARCHAR2(20) NOT NULL,
		joindate DATE DEFAULT CURRENT_DATE,
		ROLE VARCHAR2(5) DEFAULT 'user'
	);
*/

public class MemberVO {
	
	private int memberNO;
    private String memberID;
    private String password;
    private String name;
    private String phone;
    private Date joindate;
    private String role;
    
	public int getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}	
    
}
