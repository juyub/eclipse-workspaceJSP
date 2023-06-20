package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class AccountDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	 public void createAccount(AccountVO vo) {
        String accountNumber = AccountNumberGenerator.generateAccountNumber();
        String query = 
        		  " INSERT INTO jb_account (accountID, memberNO, accountPassword, balance, bankCode, openDate)"
        		+ " VALUES (?, ?, ?, ?, ?, sysdate)";

        try {
            conn = JDBCUtil.getConnection();

            stmt = conn.prepareStatement(query);
            stmt.setString(1, accountNumber);
            stmt.setInt(2, vo.getMemberNO());
            stmt.setInt(3, vo.getAccountPassword());
            stmt.setDouble(4, 0);
            stmt.setInt(5, 5);

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
	}
	
	public boolean createAccount(String accountName, double initialBalance) {
        String accountNumber = AccountNumberGenerator.generateAccountNumber();
        try {
        	conn = JDBCUtil.getConnection();
        	
            String insertAccountSql = "INSERT INTO account (account_number, account_name, balance) VALUES (?, ?, ?)";
            PreparedStatement insertAccountStmt = conn.prepareStatement(insertAccountSql);
            insertAccountStmt.setString(1, accountNumber);
            insertAccountStmt.setString(2, accountName);
            insertAccountStmt.setDouble(3, initialBalance);

            int affectedRows = insertAccountStmt.executeUpdate();
            return affectedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public boolean transferMoney(String sourceAccountNumber, String targetAccountNumber, double transferAmount, String transactionDetailName) {
        try {
        	conn = JDBCUtil.getConnection();
        	conn.setAutoCommit(false);

            String updateSourceAccountSql  = "UPDATE account SET balance = balance - ? WHERE account_number = ?";
            
            PreparedStatement updateSourceAccountStmt  = conn.prepareStatement(updateSourceAccountSql);
            updateSourceAccountStmt.setDouble(1, transferAmount);
            updateSourceAccountStmt.setString(2, sourceAccountNumber);
            
            int affectedRows1 = stmt.executeUpdate();

            String updateTargetAccountSql = "UPDATE account SET balance = balance + ? WHERE account_number = ?";
            PreparedStatement updateTargetAccountStmt = conn.prepareStatement(updateTargetAccountSql);
            updateTargetAccountStmt.setDouble(1, transferAmount);
            updateTargetAccountStmt.setString(2, targetAccountNumber);
            
            int affectedRows2 = updateTargetAccountStmt.executeUpdate();

            if (affectedRows1 > 0 && affectedRows2 > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	
	
}
