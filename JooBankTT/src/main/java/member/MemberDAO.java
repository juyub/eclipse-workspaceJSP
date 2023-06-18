package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.JDBCUtil;
import member.MemberVO;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	// 로그인 메서드
	public MemberVO getMember(MemberVO vo) {
		MemberVO member = null;
		String query = " select * from jb_member " + 
						" where memberID = ? and password = ? ";

		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getMemberID());
			stmt.setString(2, vo.getPassword());

			rs = stmt.executeQuery();
			if (rs.next()) {
				member = new MemberVO();
				member.setMemberNO(rs.getInt("memberNO"));
				member.setMemberID(rs.getString("memberID"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setJoindate(rs.getDate("joindate"));
				member.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return member;
	}
	
	// 회원가입 메서드
	public void addUser(MemberVO vo) {
		String query = " insert into jb_member (memberNO, memberID, password, name, phone) " + 
	                                  " values (member_seq.NEXTVAL,?,?,?,?) ";
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, vo.getMemberID());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getPhone());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
}
