package account;

import java.util.Date;

/*
	CREATE TABLE jb_account (
		accountID NUMBER(12) PRIMARY KEY,
		memberNO NUMBER(10, 0),
		accountPassword NUMBER(4),
		balance DECIMAL(15, 2),
		bankCode NUMBER(3),
		openDate DATE,
		FOREIGN KEY (memberNO) REFERENCES jb_member(memberNO),
		FOREIGN KEY (bankCode) REFERENCES bank_cd(bankCode)
	);
	
	CREATE TABLE bank_cd (
	    bankCode NUMBER(3) PRIMARY KEY,
	    bankName VARCHAR2(50)
	);
*/

public class AccountVO {

    private int accountID;
    private int memberNO;
    private int accountPassword;
    private double balance;
    private int bankCode;
    private Date openDate;
    
    private String bankName;

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

	public int getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(int accountPassword) {
		this.accountPassword = accountPassword;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
    
}
