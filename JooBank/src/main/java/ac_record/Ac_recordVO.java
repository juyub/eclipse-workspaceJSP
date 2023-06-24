package ac_record;

import java.sql.Timestamp;

/*
CREATE TABLE account (
    ac_number NUMBER(15),
    id VARCHAR2(50),
    AC_PW VARCHAR2(4),
    AC_NAME VARCHAR2(20),
    AC_MONEY NUMBER(20),
    AC_OP_DATE DATE DEFAULT CURRENT_DATE,
    AC_ED_DATE DATE,
    STATE VARCHAR2(10),
    PD_NUMBER NUMBER(15),
    bank_cd VARCHAR2(3),
    PRIMARY KEY (ac_number, id),
    FOREIGN KEY (bank_cd) REFERENCES bankinfo(bank_cd)
);

CREATE TABLE bankinfo (
    bank_cd VARCHAR2(20) PRIMARY KEY,
    bank_name VARCHAR2(50)
);

CREATE TABLE product (
    PD_NUMBER number(15) PRIMARY KEY,
    pd_name VARCHAR2(50),
    pd_content VARCHAR2(1000)
);

CREATE TABLE ac_record (
    rc_no NUMBER PRIMARY KEY,
    ac_number NUMBER(15),
    id VARCHAR2(50),
    rc_type VARCHAR2(50),
    rc_name VARCHAR2(50),
    rc_money NUMBER(15),
    rc_time TIMESTAMP DEFAULT TRUNC(SYSTIMESTAMP, 'MI'),
    FOREIGN KEY (ac_number, id) REFERENCES account(ac_number, id)
);
*/


public class Ac_recordVO {

	private int ac_number;
    private String id;
    private String rc_type;
    private String rc_name;
    private int rc_money;
    private Timestamp rc_time;
    
    private int AC_MONEY;
    private String bank_name;
    
	public int getAc_number() {
		return ac_number;
	}

	public void setAc_number(int ac_number) {
		this.ac_number = ac_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRc_type() {
		return rc_type;
	}

	public void setRc_type(String rc_type) {
		this.rc_type = rc_type;
	}

	public String getRc_name() {
		return rc_name;
	}

	public void setRc_name(String rc_name) {
		this.rc_name = rc_name;
	}

	public int getRc_money() {
		return rc_money;
	}

	public void setRc_money(int rc_money) {
		this.rc_money = rc_money;
	}

	public Timestamp getRc_time() {
		return rc_time;
	}

	public void setRc_time(Timestamp rc_time) {
		this.rc_time = rc_time;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public int getAC_MONEY() {
		return AC_MONEY;
	}

	public void setAC_MONEY(int aC_MONEY) {
		AC_MONEY = aC_MONEY;
	}
	
}
