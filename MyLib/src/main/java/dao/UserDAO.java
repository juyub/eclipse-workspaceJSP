package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import vo.UserVO;


public class UserDAO {

	public void addUser(UserVO user) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_user(no, name, phone) "); 
		sql.append(" values(seq_t_user_no.nextval, ?, ?) "); 
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPhone());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<UserVO> selectAllUser(){
		
		List<UserVO> userList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, name, phone ");
		sql.append("  from t_user");
		sql.append(" order by no desc ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int no = rs.getInt("no");
				String name   = rs.getString("name");
				String phone = rs.getString("phone");
				
				UserVO user = new UserVO();
				user.setNo(no);
				user.setName(name);
				user.setPhone(phone);
				
				userList.add(user);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	public UserVO selectUserByNo(int joinNo) {
		
		UserVO user = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, name, phone ");
		sql.append("  from t_user ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, joinNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				
				user = new UserVO(no, name, phone);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public UserVO selectUserByName(String name) {
        UserVO user = null;
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT no, name, phone ");
        sql.append(" FROM t_user ");
        sql.append(" WHERE name LIKE '%' || ? || '%' ");

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            pstmt.setString(1, name);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int no = rs.getInt("no");
                    String userName = rs.getString("name");
                    String phone = rs.getString("phone");

                    user = new UserVO();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
	
	public UserVO selectUserByID(String id) {
        UserVO user = null;
//      StringBuilder sql = new StringBuilder();
        String sql = " SELECT id, password, name, phone " +
        			 " FROM t_user2 " +
        			 " WHERE id LIKE ? " ;
//        sql.append(" SELECT id, password, name, phone ");
//        sql.append(" FROM t_user2 ");
//        sql.append(" WHERE id LIKE ? ");

        try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql/* .toString() */)) {

            pstmt.setString(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	 String userId = rs.getString("id");
                     String password = rs.getString("password");
                     String name = rs.getString("name");
                     String phone = rs.getString("phone");

                     user = new UserVO(userId, password, name, phone);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
	
//	public List<UserVO> selectUserByName(String name) {
//	    List<UserVO> userList = new ArrayList<>();
//	    StringBuilder sql = new StringBuilder();
//	    sql.append(" SELECT no, name, phone ");
//	    sql.append(" FROM t_user ");
//	    sql.append(" WHERE name LIKE '%' || ? || '%' ");
//
//	    try (Connection conn = new ConnectionFactory().getConnection();
//	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
//
//	        pstmt.setString(1, name);
//
//	        try (ResultSet rs = pstmt.executeQuery()) {
//	            while (rs.next()) {
//	                int no = rs.getInt("no");
//	                String userName = rs.getString("name");
//	                String phone = rs.getString("phone");
//
//	                UserVO user = new UserVO(no, userName, phone);
//	                userList.add(user);
//	            }
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//
//	    return userList;
//	}
	
	public UserVO deleteUser(int No) {
		UserVO user = null;
		
		StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM t_user WHERE no = ?");
	    
        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setInt(1, No);
            pstmt.executeUpdate();
        } catch (Exception e) {
			e.printStackTrace();
		}
        return user;
    }
	
	public boolean updateUser(UserVO updatedUser) {
	    boolean updated = false;

	    String sql = "UPDATE t_user2 SET password=?, name=?, phone=? WHERE id=?";

	    try (Connection conn = new ConnectionFactory().getConnection();
	    	    PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	        pstmt.setString(1, updatedUser.getPassword());
	    	        pstmt.setString(2, updatedUser.getName());
	    	        pstmt.setString(3, updatedUser.getPhone());
	    	        pstmt.setString(4, updatedUser.getId());
	    	        pstmt.executeUpdate();
	    	        updated = true;
	    	} catch (Exception e) {
	    	    e.printStackTrace();
	    	} 
	    return updated;

	}

}
