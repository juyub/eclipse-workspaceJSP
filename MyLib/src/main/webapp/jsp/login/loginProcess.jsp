<%@page import="vo.UserVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		작업순서
		1. 파라미터 추출(아이디, 패스워드)
		2. 추출된 파라미터를 가진 회원 검색
		3. 검색결과에 따른 화면 구성
	*/
	
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	ConnectionFactory connectionFactory = new ConnectionFactory();
	
	String sql = " select * from t_user2 " +
			     "  where id = ? and password = ? ";
	
	try(
			Connection conn = connectionFactory.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);
	) {
		
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		
		String msg = "";
		String locUrl = "";
		if(rs.next()) {
			
			UserVO loginUser = new UserVO();
			loginUser.setId(rs.getString("id"));
			loginUser.setPassword(rs.getString("password"));
			loginUser.setName(rs.getString("name"));
			loginUser.setPhone(rs.getString("phone"));
			loginUser.setType(rs.getString("type"));
			
			msg = loginUser.getName() + "님 환영합니다";
			locUrl = "/MyLib";
			
			session.setAttribute("loginUser", loginUser);
			
		} else {
			msg = "입력하신 ID 또는 패스워드가 잘못되었습니다";
			locUrl = "login.jsp";
		}
		
		pageContext.setAttribute("msg", msg);
		pageContext.setAttribute("url", locUrl);
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
%>    

<script>
	alert('${ msg }')
	location.href = '${ url }'
</script>








