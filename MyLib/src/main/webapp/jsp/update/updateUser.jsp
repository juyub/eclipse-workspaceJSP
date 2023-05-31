<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<% 
    UserVO user = (UserVO) session.getAttribute("loginUser");
    %>
	
	<!-- "UpdateUserController" -->
	<form action="/MyLib/update-user" method="post">
		<table>
			<tr>
				<td>ID:</td>
				<td><%=user.getId()%></td>
				
			</tr>
			<tr>
				<td>비밀번호:</td>
				<td><input type="password" name="password"
					value="<%=user.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>이름:</td>
				<td><%=user.getName()%>
				<!--<input type="text" name="name"
					value="<%=user.getName()%>" readonly onfocus="this.blur()" />  --> </td>
			</tr>
			<tr>
				<td>전화번호:</td>
				<td><input type="text" name="phone"
					value="<%=user.getPhone()%>" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="정보 수정" /></td>
			</tr>
		</table>
	</form>
</body>
</html>