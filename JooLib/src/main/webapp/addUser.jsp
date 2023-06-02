<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원가입 </h1>
<hr>
<form action="addUser.do" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="phone"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="회원가입"/></td>
		</tr>
	</table>
</form>
<br>
<a href="login.html">로그인</a>
</body>
</html>