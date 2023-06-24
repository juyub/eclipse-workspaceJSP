package account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ac_record.Ac_recordDAO;
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
	
	// Ac_number 로 조회
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
	public int deposit(int ac_number, int depositAmount,boolean withTransactionLog) {
	    String query = " UPDATE account SET AC_MONEY = AC_MONEY + ? WHERE ac_number = ? ";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, depositAmount);
	        stmt.setInt(2, ac_number);

	        result = stmt.executeUpdate();

	        // Insert transaction history for deposit
	        if (result > 0 && withTransactionLog) {
	        	AccountVO account = getAccount(ac_number);
		        String Id = account.getId();
		        String Name = account.getName();
		        
		        Ac_recordDAO ac_recordDAO = new Ac_recordDAO(); // 클래스 인스턴스 생성
	            ac_recordDAO.insertTransaction(ac_number, Id, "입금", Name, depositAmount);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }

	    return result;
	}

	// 출금
	public int withdraw(int ac_number, int withdrawAmount,boolean withTransactionLog) {
	    String query = " UPDATE account SET AC_MONEY = AC_MONEY - ? WHERE ac_number = ? ";
	    int result = 0;

	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, withdrawAmount);
	        stmt.setInt(2, ac_number);

	        result = stmt.executeUpdate();

	        // Insert transaction history for withdrawal
	        if (result > 0 && withTransactionLog) {
	        	AccountVO account = getAccount(ac_number);
		        String Id = account.getId();
		        String Name = account.getName();
		        
		        Ac_recordDAO ac_recordDAO = new Ac_recordDAO(); // 클래스 인스턴스 생성
	            ac_recordDAO.insertTransaction(ac_number, Id, "출금", Name, withdrawAmount);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        JDBCUtil.close(stmt, conn);
	    }

	    return result;
	}

	// 이체
	public int transfer(int sendAc_number, int receivAc_number, int transferAmount) {
	    int result = 0;

	    // 출금
	    int withdrawalResult = withdraw(sendAc_number, transferAmount, false);

	    // 입금
	    int depositResult = deposit(receivAc_number, transferAmount, false);

	    // 입출금 결과가 성공적이면 이체 내역 저장
	    if (withdrawalResult > 0 && depositResult > 0) {
	    	
	    	AccountVO sendAccount = getAccount(sendAc_number);
	        int sendTransactionedAC_MONEY = sendAccount.getAC_MONEY();
	        String sendId = sendAccount.getId();
	        String sendName = sendAccount.getName();
	        
	        AccountVO receivAccount = getAccount(receivAc_number);
	        int receivTransactionedAC_MONEY = receivAccount.getAC_MONEY();
	        String receivId = receivAccount.getId();
	        String receivName = receivAccount.getName();
	        		
	        // 출금 이력 추가
	        Ac_recordDAO ac_recordDAO = new Ac_recordDAO(); // 클래스 인스턴스 생성
            ac_recordDAO.insertTransaction(sendAc_number, sendId, "송금", receivName, transferAmount);

	        // 입금 이력 추가
            ac_recordDAO.insertTransaction(receivAc_number, receivId, "수금", sendName, transferAmount);

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

	public AccountVO getAccount(int ac_number) {
	    AccountVO account = null;
	    String query = "SELECT c.ac_number, c.id, ui.NAME, c.AC_NAME, c.AC_MONEY, c.AC_OP_DATE, c.bank_name, d.pd_name "
	            + "FROM ("
	            + "   SELECT a.ac_number, a.id, a.AC_NAME, a.AC_MONEY, a.AC_OP_DATE, a.PD_NUMBER, b.bank_name "
	            + "   FROM account a "
	            + "   JOIN bankinfo b ON b.bank_cd = a.bank_cd "
	            + ") c "
	            + "JOIN product d ON d.PD_NUMBER = c.PD_NUMBER "
	            + "JOIN USER_INFO ui ON ui.ID = c.id "
	            + "WHERE c.ac_number = ?";
	    
	    try {
	        conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(query);
	        stmt.setInt(1, ac_number);
	        
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
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

	// getAccount로 통합
//	public int getCurrentAC_MONEY(int ac_number) {
//	    String query = "SELECT AC_MONEY FROM account WHERE ac_number = ?";
//	    int currentAC_MONEY = 0;
//
//	    try {
//	        conn = JDBCUtil.getConnection();
//	        stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, ac_number);
//
//	        ResultSet rs = stmt.executeQuery();
//	        if (rs.next()) {
//	            currentAC_MONEY = rs.getInt("AC_MONEY");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        JDBCUtil.close(rs, stmt, conn);
//	    }
//
//	    return currentAC_MONEY;
//	}
//	
//	public String getId(int ac_number) {
//	    String query = "SELECT id FROM account WHERE ac_number = ?";
//	    String Id = null;
//
//	    try {
//	        conn = JDBCUtil.getConnection();
//	        stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, ac_number);
//
//	        ResultSet rs = stmt.executeQuery();
//	        if (rs.next()) {
//	        	Id = rs.getString("id");
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        JDBCUtil.close(rs, stmt, conn);
//	    }
//
//	    return Id;
//	}
	
	// 입출금내역 - Ac_recordDAO로 보냄
//	public void insertTransaction(int ac_number, String id, String type, String name, int transferAmount) {
//	    String query = "INSERT INTO ac_record(rc_no, ac_number, id, rc_type, rc_name, rc_money ) "
//	                 + "VALUES(seq_rc_no.NEXTVAL,?, ?, ?, ?,?)";
//
//	    try {
//	        conn = JDBCUtil.getConnection();
//	        stmt = conn.prepareStatement(query);
//	        stmt.setInt(1, ac_number);
//	        stmt.setString(2, id);
//            stmt.setString(3, type);
//            stmt.setString(4, name);
//	        stmt.setInt(5, transferAmount);
//
//	        stmt.executeUpdate();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    } finally {
//	        JDBCUtil.close(stmt, conn);
//	    }
//	}

	// 오버로드 메서드를 추가
	public int deposit(int ac_number, int depositAmount) {
	    return deposit(ac_number, depositAmount, true);
	}

	public int withdraw(int ac_number, int withdrawAmount) {
	    return withdraw(ac_number, withdrawAmount, true);
	}
}
