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
	    		  " INSERT INTO account (ac_number, id, AC_PW, AC_MONEY, bank_cd, AC_OP_DATE, PD_NUMBER)"
	    			+ " VALUES (?, ?, ?, ?, ?, sysdate,?)";
	
	    try {
	        conn = JDBCUtil.getConnection();
	
	        stmt = conn.prepareStatement(query);
	        stmt.setString(1, accountNumber);
	        stmt.setString(2, vo.getId());
	        stmt.setString(3, vo.getAC_PW());
	        stmt.setInt(4, 0);
	        stmt.setInt(5, 5);
	        stmt.setInt(6, 1);
	
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
				" SELECT c.ac_number, c.id, ui.NAME, c.AC_NAME, c.AC_MONEY, c.AC_OP_DATE, c.bank_name, d.pd_name "
				+ " FROM ("
				 +  " SELECT a.ac_number, a.id, a.AC_NAME, a.AC_MONEY, a.AC_OP_DATE, a.PD_NUMBER, b.bank_name "
				 +   " FROM account a "
				 +  " JOIN bankinfo b ON b.bank_cd = a.bank_cd "
			    + " ) c "
				+ " JOIN product d ON d.PD_NUMBER = c.PD_NUMBER "
				+ " JOIN USER_INFO ui ON ui.ID = c.id "
				+ " WHERE c.id = ? ORDER BY c.AC_OP_DATE DESC ";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				AccountVO account = new AccountVO();
				account.setAc_number(rs.getInt("ac_number"));
				account.setId(rs.getString("id"));
				account.setAC_NAME(rs.getString("AC_NAME"));
				account.setAC_MONEY(rs.getInt("AC_MONEY"));
				account.setAC_OP_DATE(rs.getDate("AC_OP_DATE"));
				account.setBank_name(rs.getString("bank_name"));
				account.setPd_name(rs.getString("pd_name"));
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
	public AccountVO getAc_number(AccountVO vo) {
		AccountVO account = null;
		String query =
				" SELECT c.ac_number, c.id, ui.NAME, c.AC_NAME, c.AC_MONEY, c.AC_OP_DATE, c.bank_name, d.pd_name "
						+ " FROM ("
						 +  " SELECT a.ac_number, a.id, a.AC_NAME, a.AC_MONEY, a.AC_OP_DATE, a.PD_NUMBER, b.bank_name "
						 +   " FROM account a "
						 +  " JOIN bankinfo b ON b.bank_cd = a.bank_cd "
					    + " ) c "
						+ " JOIN product d ON d.PD_NUMBER = c.PD_NUMBER "
						+ " JOIN USER_INFO ui ON ui.ID = c.id "
				+ " where c.ac_number = ? ";
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, vo.getAc_number());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				account = new AccountVO();
				account.setAc_number(rs.getInt("ac_number"));
				account.setId(rs.getString("id"));
				account.setAC_NAME(rs.getString("AC_NAME"));
				account.setAC_MONEY(rs.getInt("AC_MONEY"));
				account.setAC_OP_DATE(rs.getDate("AC_OP_DATE"));
				account.setBank_name(rs.getString("bank_name"));
				account.setPd_name(rs.getString("pd_name"));
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
	public int deposit(int ac_number, int depositAmount) {
	    String query = " UPDATE account SET AC_MONEY = AC_MONEY + ? WHERE ac_number = ? ";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, depositAmount);
	        stmt.setInt(2, ac_number);

	        result = stmt.executeUpdate();

	        // Insert transaction history for deposit
//	        if (result > 0) {
//	            int transactionedBalance = getCurrentAC_MONEY(ac_number) + depositAmount;
//	            insertTransaction(ac_number, "3", depositAmount, "deposit", ac_number, "deposit", transactionedBalance);
//	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }

	    return result;
	}

	// 출금
	public int withdraw(int ac_number, int withdrawAmount) {
	    String query = " UPDATE account SET AC_MONEY = AC_MONEY - ? WHERE ac_number = ? ";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, withdrawAmount);
	        stmt.setInt(2, ac_number);

	        result = stmt.executeUpdate();

	        // Insert transaction history for withdrawal
//	        if (result > 0) {
//	            int transactionedBalance = getCurrentAC_MONEY(ac_number) - withdrawAmount;
//	            insertTransaction(ac_number, "3", withdrawAmount, "withdraw", ac_number, "withdraw", transactionedBalance);
//	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }

	    return result;
	}
	
	// 이체
	public int transfer(int senderAccountID, int receiverAccountID, int transferAmount) {
	    int result = 0;

	    // 출금
	    int withdrawalResult = withdraw(senderAccountID, transferAmount);

	    // 입금
	    int depositResult = deposit(receiverAccountID, transferAmount);

	    // 입출금 결과가 성공적이면 이체 내역 저장
//	    if (withdrawalResult > 0 && depositResult > 0) {
//	        int senderTransactionedBalance = getCurrentAC_MONEY(senderAccountID) - transferAmount;
//	        int receiverTransactionedBalance = getCurrentAC_MONEY(receiverAccountID) + transferAmount;
//
//	        // 출금 이력 추가
//	        insertTransaction(senderAccountID, "3", transferAmount, "transfer", receiverAccountID, "transfer", senderTransactionedBalance);
//
//	        // 입금 이력 추가
//	        insertTransaction(receiverAccountID, "3", transferAmount, "transfer", senderAccountID, "transfer", receiverTransactionedBalance);
//
//	        result = 1;
//	    } else {
//	        // 실패한 경우 롤백 처리
//	        try {
//	            conn.rollback();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }

	    return result;
	}
	
	// 입출금내역
//	public void insertTransaction(int ac_number, String bankCode, int amount, String transactionType, int targetAccountID, String transactionDetails, int transactionedBalance) {
//	    String query = "INSERT INTO ac_record(ac_number, id, rc_type, rc_name, rc_money) "
//	                 + "VALUES(?, ?, ?, ?, ?)";
//
//	    try {
//	        conn = JDBCUtil.getConnection();
//	        stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, ac_number);
//	        stmt.setString(2, bankCode);
//	        stmt.setString(3, transactionType);
//	        stmt.setString(4, transactionDetails);
//	        stmt.setInt(5, amount);
//
//	        stmt.executeUpdate();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        JDBCUtil.close(stmt, conn);
//	    }
//	}
	
	public int getCurrentAC_MONEY(int ac_number) {
	    String query = "SELECT AC_MONEY FROM account WHERE ac_number = ?";
	    int currentAC_MONEY = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, ac_number);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            currentAC_MONEY = rs.getInt("AC_MONEY");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(rs, stmt, conn);
	    }

	    return currentAC_MONEY;
	}
	
}
