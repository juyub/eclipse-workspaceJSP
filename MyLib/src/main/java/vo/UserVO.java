package vo;

/*
CREATE TABLE t_user(
    id VARCHAR2(100) PRIMARY KEY,
    password VARCHAR2(100) NOT NULL,
    name VARCHAR2(100),
    phone VARCHAR2(11)
    type CHAR(1) DEFAULT 'U',
);
 */

public class UserVO {

	private String id;
	private String password;
	private String name;
	private String phone;
	private String type;
	
	public UserVO() {
		super();
	}
	
	public UserVO(String id, String password, String name, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
//	@Override
//	public String toString() {
//		return "UserVO [no=" + no + ", name=" + name + ", phone=" + phone + "]";
//	}
	
}
