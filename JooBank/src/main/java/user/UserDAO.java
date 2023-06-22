package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;

public class UserDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// 회원가입
	public void addUser (UserVO vo) {
		String query = 
				" insert into USER_INFO (id, password, name, usercode,phone,email,postcode,address) " + 
	                           " values (?,?,?,?,?,?,?,?) ";
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getUsercode());
			stmt.setString(5, vo.getPhone());
			stmt.setString(6, vo.getEmail());
			stmt.setString(7, vo.getPostcode());
			stmt.setString(8, vo.getAddress());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	// 로그인
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		String query = " select * from USER_INFO " + 
						" where id = ? and password = ? ";
	
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
	
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setUser_type(rs.getString("user_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}
	
	
}
