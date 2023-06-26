package product;

/*
	CREATE TABLE product (
	    PD_NUMBER number(15) PRIMARY KEY,
	    pd_name VARCHAR2(50),
	    pd_content VARCHAR2(1000)
	);
 */

public class ProductVO {

	private int pd_number;
	private String pd_name;
	private String pd_content;
	
	public int getPd_number() {
		return pd_number;
	}
	public void setPd_number(int pd_number) {
		this.pd_number = pd_number;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_content() {
		return pd_content;
	}
	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}
	
}
