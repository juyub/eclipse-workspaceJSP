package account;

import java.sql.Timestamp;

/*
	CREATE TABLE transaction_info (
	    transactionID NUMBER(12) PRIMARY KEY,
	    accountID NUMBER(12),
	    bankCode VARCHAR2(3),
	    transactionAmount DECIMAL(15, 2),
	    transactionType VARCHAR2(20),
	    targetAccountID NUMBER(12),
	    transactionDetail VARCHAR2(100),
	    transactionedBalance DECIMAL(15, 2),
	    transactionTime TIMESTAMP,
	    FOREIGN KEY (accountID) REFERENCES jb_account(accountID),
	    FOREIGN KEY (targetAccountID) REFERENCES jb_account(accountID)
	);
*/

public class TransactionInfoVo {
	
	private int transactionID;
    private int accountID;
    private String bankCode;
    private double transactionAmount;
    private String transactionType;
    private int targetAccountID;
    private String transactionDetail;
    private double transactionedBalance;
    private Timestamp transactionTime;

    private String bankName;
    
    private String name;

	public int getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTargetAccountID() {
		return targetAccountID;
	}

	public void setTargetAccountID(int targetAccountID) {
		this.targetAccountID = targetAccountID;
	}

	public String getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(String transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public double getTransactionedBalance() {
		return transactionedBalance;
	}

	public void setTransactionedBalance(double transactionedBalance) {
		this.transactionedBalance = transactionedBalance;
	}

	public Timestamp getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Timestamp transactionTime) {
		this.transactionTime = transactionTime;
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
