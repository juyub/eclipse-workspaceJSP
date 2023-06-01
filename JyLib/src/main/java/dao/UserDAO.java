package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import vo.UserVO;

public class UserDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private static String USER_GET =
			" select * from users " +
			" where userid = ? and password = ? ";
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();
	        stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getUserid() );
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setUserid(rs.getString("userid"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}

	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}

	// JDBC driver, url, username, password 설정
    
    // 데이터베이스 연결 메서드

    // 사용자 정보 추가 메서드

    // 사용자 정보 조회(전체 또는 특정 조건) 메서드

    // 사용자 정보 수정 메서드

    // 사용자 정보 삭제 메서드
	
}