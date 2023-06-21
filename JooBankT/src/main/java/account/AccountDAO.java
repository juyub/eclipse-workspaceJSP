package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class AccountDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// 계좌 생성
	public void createAccount(AccountVO vo) {
	    String accountNumber = AccountNumberGenerator.generateAccountNumber();
	    String query = 
	    		  " INSERT INTO jb_account (accountID, memberNO, accountPassword, balance, bankCode, openedDate)"
	    			+ " VALUES (?, ?, ?, ?, ?, sysdate)";
	
	    try {
	        conn = JDBCUtil.getConnection();
	
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, accountNumber);
	        stmt.setInt(2, vo.getMemberNO());
	        stmt.setString(3, vo.getAccountPassword());
	        stmt.setDouble(4, 0);
	        stmt.setInt(5, 5);
	
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(rs, stmt, conn);
	    }
	}

	// 내 계좌 목록
	public List<AccountVO> myAccountList(AccountVO vo) {
		List<AccountVO> accountList = new ArrayList<AccountVO>();
		String query = 
				" SELECT c.accountID, c.memberNO, c.accountPassword, c.balance, c.openedDate, c.bankName, d.name "
				+ " from ( "
						+ " SELECT a.accountID, a.memberNO, a.accountPassword, a.balance, a.openedDate, b.bankName " 
					    + " FROM jb_account a "
					    + " JOIN bank_cd b ON a.bankCode = b.bankCode "
					    + " ) c "
			    + " JOIN jb_member d ON c.memberNO = d.memberNO "
			    + " WHERE c.memberNO=? ORDER BY c.openedDate DESC "; 


		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, vo.getMemberNO());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				AccountVO account = new AccountVO();
				account.setAccountID(rs.getInt("accountID"));
				account.setMemberNO(rs.getInt("memberNO"));
				account.setAccountPassword(rs.getString("accountPassword"));
				account.setBalance(rs.getDouble("balance"));
				account.setOpenedDate(rs.getDate("openedDate"));
				account.setBankName(rs.getString("bankName"));
				account.setName(rs.getString("name"));
				accountList.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return accountList;
	}
	
	// AccountID 로 조회
	public AccountVO getAccountID(AccountVO vo) {
		AccountVO account = null;
		String query =
				" SELECT c.accountID, c.memberNO, c.accountPassword, c.balance, c.openedDate, c.bankCode, c.bankName, d.name "
				+ " from ( "
						+ " SELECT a.accountID, a.memberNO, a.accountPassword, a.balance, a.openedDate, a.bankCode, b.bankName " 
					    + " FROM jb_account a "
					    + " JOIN bank_cd b ON a.bankCode = b.bankCode "
					    + " ) c "
			    + " JOIN jb_member d ON c.memberNO = d.memberNO "
				+ " where c.accountID = ? ";
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, vo.getAccountID());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				account = new AccountVO();
				account.setAccountID(rs.getInt("accountID"));
				account.setMemberNO(rs.getInt("memberNO"));
				account.setAccountPassword(rs.getString("accountPassword"));
				account.setBalance(rs.getDouble("balance"));
				account.setOpenedDate(rs.getDate("openedDate"));
				account.setBankCode(rs.getString("bankCode"));
				account.setBankName(rs.getString("bankName"));
				account.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return account;
	}
	
	// 입금
	public int deposit(int accountID, double depositAmount) {
	    String query = "UPDATE jb_account SET balance = balance + ? WHERE accountID = ?";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setDouble(1, depositAmount);
	        stmt.setInt(2, accountID);

	        result = stmt.executeUpdate();

	        // Insert transaction history for deposit
	        if (result > 0) {
	            double transactionedBalance = getCurrentBalance(accountID) + depositAmount;
	            insertTransaction(accountID, "3", depositAmount, "deposit", accountID, "deposit", transactionedBalance);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

	// 출금
	public int withdraw(int accountID, double withdrawAmount) {
	    String query = "UPDATE jb_account SET balance = balance - ? WHERE accountID = ?";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setDouble(1, withdrawAmount);
	        stmt.setInt(2, accountID);

	        result = stmt.executeUpdate();

	        // Insert transaction history for withdrawal
	        if (result > 0) {
	            double transactionedBalance = getCurrentBalance(accountID) - withdrawAmount;
	            insertTransaction(accountID, "3", withdrawAmount, "withdraw", accountID, "withdraw", transactionedBalance);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	// 이체
	public int transfer(int senderAccountID, int receiverAccountID, double transferAmount) {
	    int result = 0;

	    // 출금
	    int withdrawalResult = withdraw(senderAccountID, transferAmount);

	    // 입금
	    int depositResult = deposit(receiverAccountID, transferAmount);

	    // 입출금 결과가 성공적이면 이체 내역 저장
	    if (withdrawalResult > 0 && depositResult > 0) {
	        double senderTransactionedBalance = getCurrentBalance(senderAccountID) - transferAmount;
	        double receiverTransactionedBalance = getCurrentBalance(receiverAccountID) + transferAmount;

	        // 출금 이력 추가
	        insertTransaction(senderAccountID, "3", transferAmount, "transfer", receiverAccountID, "transfer", senderTransactionedBalance);

	        // 입금 이력 추가
	        insertTransaction(receiverAccountID, "3", transferAmount, "transfer", senderAccountID, "transfer", receiverTransactionedBalance);

	        result = 1;
	    } else {
	        // 실패한 경우 롤백 처리
	        try {
	            conn.rollback();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return result;
	}
	
	// 입출금내역
	public void insertTransaction(int accountID, String bankCode, double amount, String transactionType, int targetAccountID, String transactionDetails, double transactionedBalance) {
	    String query = "INSERT INTO transaction_info(transactionID, accountID, bankCode, transactionAmount, transactionType, targetAccountID, transactionDetail, transactionedBalance, transactionTime) "
	            + "VALUES(transaction_id_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, TRUNC(SYSTIMESTAMP, 'MI'))";

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, accountID);
	        stmt.setString(2, bankCode);
	        stmt.setDouble(3, amount);
	        stmt.setString(4, transactionType);
	        stmt.setInt(5, targetAccountID);
	        stmt.setString(6, transactionDetails);
	        stmt.setDouble(7, transactionedBalance);

	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	public double getCurrentBalance(int accountID) {
	    String query = "SELECT balance FROM jb_account WHERE accountID = ?";
	    double currentBalance = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, accountID);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            currentBalance = rs.getDouble("balance");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return currentBalance;
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
