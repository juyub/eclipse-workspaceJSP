package ac_record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import account.AccountVO;
import common.JDBCUtil;

public class Ac_recordDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 입출금내역 산입
	public void insertTransaction(int ac_number, String id, String type, String name, int transferAmount, int AC_MONEY) {
		String query = "INSERT INTO ac_record(rc_no, ac_number, id, rc_type, rc_name, rc_money, rc_balance ) "
				+ "VALUES(seq_rc_no.NEXTVAL,?, ?, ?, ?,?,?)";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, ac_number);
			stmt.setString(2, id);
			stmt.setString(3, type);
			stmt.setString(4, name);
			stmt.setInt(5, transferAmount);
			stmt.setInt(6, AC_MONEY);

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 거래 내역 목록
	public List<Ac_recordVO> getAc_recordList(int ac_number, int pageNo, int pageSize) {
		List<Ac_recordVO> ac_recordList = new ArrayList<Ac_recordVO>();
		String query = 
				" SELECT * FROM ( "
			    + " SELECT ac_record.ac_number, ac_record.id, ac_record.rc_type, ac_record.rc_name, ac_record.rc_money, ac_record.rc_time, "
			    + " ac_record.rc_balance, bankinfo.bank_name, ROW_NUMBER() OVER (ORDER BY ac_record.rc_time DESC) as row_num FROM ac_record "
			    + " JOIN account ON ac_record.ac_number = account.ac_number AND ac_record.id = account.id "
			    + " JOIN bankinfo ON account.bank_cd = bankinfo.bank_cd "
			    + " WHERE ac_record.ac_number = ? ) T "
			    + " WHERE T.row_num BETWEEN ((? - 1) * ?) + 1 AND ? * ? ";

//				" SELECT * FROM "
//				+ " (SELECT ac_record.ac_number, ac_record.id, ac_record.rc_type, ac_record.rc_name, ac_record.rc_money, ac_record.rc_time, "
//				+ " ac_record.rc_balance, bankinfo.bank_name, ROWNUM as row_num " + "FROM ac_record "
//				+ " JOIN account ON ac_record.ac_number = account.ac_number " + "AND ac_record.id = account.id "
//				+ " JOIN bankinfo ON account.bank_cd = bankinfo.bank_cd " + "WHERE ac_record.ac_number = ? "
//				+ " AND ROWNUM <= ? * ? " + "ORDER BY ac_record.rc_time DESC) T " + "WHERE T.row_num > ? * ? - ? ";

		try {
		    conn = JDBCUtil.getConnection();
		    stmt = conn.prepareStatement(query);
		    stmt.setInt(1, ac_number);
		    stmt.setInt(2, pageNo);
		    stmt.setInt(3, pageSize);
		    stmt.setInt(4, pageNo);
		    stmt.setInt(5, pageSize);

		    rs = stmt.executeQuery();
		    while (rs.next()) {
		        Ac_recordVO record = new Ac_recordVO();
		        record.setAc_number(rs.getInt("ac_number"));
		        record.setId(rs.getString("id"));
		        record.setRc_type(rs.getString("rc_type"));
		        record.setRc_name(rs.getString("rc_name"));
		        record.setRc_money(rs.getInt("rc_money"));
		        record.setRc_time(rs.getTimestamp("rc_time"));
		        record.setBank_name(rs.getString("bank_name"));
		        record.setRc_balance(rs.getInt("rc_balance"));
		        ac_recordList.add(record);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    JDBCUtil.close(rs, stmt, conn);
		}

		return ac_recordList;
	}

	public int getAc_recordCount(int ac_number) {
		int count = 0;
		String query = "SELECT COUNT(*) AS count FROM ac_record WHERE ac_number = ? ";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, ac_number);
			rs = stmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return count;
	}

}
