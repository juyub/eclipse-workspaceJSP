package openbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class OpenbankDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List<OpenbankVO> myAccountList(OpenbankVO vo) {
		List<OpenbankVO> accountList = new ArrayList<OpenbankVO>();
		String query = 
				 " SELECT ac_number, id, AC_NAME, AC_MONEY, AC_OP_DATE, AC_ED_DATE, PD_NUMBER "
				 +   " FROM account@test_link ";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getId());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				OpenbankVO account = new OpenbankVO();
				account.setAc_number(rs.getInt("ac_number"));
				account.setId(rs.getString("id"));
				account.setAC_NAME(rs.getString("AC_NAME"));
				account.setAC_MONEY(rs.getInt("AC_MONEY"));
				account.setAC_OP_DATE(rs.getDate("AC_OP_DATE"));
				account.setAC_ED_DATE(rs.getDate("AC_ED_DATE"));
				accountList.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return accountList;
	}
	
}
