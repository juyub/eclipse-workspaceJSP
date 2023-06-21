package account;

import java.util.Date;

/*
	CREATE TABLE jb_account (
	    accountID NUMBER(12) PRIMARY KEY,
	    memberNO NUMBER(10, 0),
	    accountPassword VARCHAR2(4),
	    balance DECIMAL(15, 2),
	    bankCode VARCHAR2(3),
	    openedDate DATE,
	    FOREIGN KEY (memberNO) REFERENCES jb_member(memberNO),
	    FOREIGN KEY (bankCode) REFERENCES bank_cd(bankCode)
	);
	
	CREATE TABLE bank_cd (
	    bankCode VARCHAR2(3) PRIMARY KEY,
	    bankName VARCHAR2(50)
	);
*/

public class AccountVO {

    private int accountID;
    private int memberNO;
    private String accountPassword;
    private double balance;
    private String bankCode;
    private Date openedDate;
    
    private String bankName;
    
    private String name;

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getMemberNO() {
		return memberNO;
	}

	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
