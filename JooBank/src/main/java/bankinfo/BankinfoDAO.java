package bankinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;

public class BankinfoDAO {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public List<BankinfoVO> getBankList() {
		List<BankinfoVO> bankList = new ArrayList<BankinfoVO>();
		String query = 
				" SELECT * from bankinfo";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BankinfoVO bank = new BankinfoVO();
				bank.setBank_cd(rs.getString("bank_cd"));
				bank.setBank_name(rs.getString("bank_name"));
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return bankList;
	}

}
