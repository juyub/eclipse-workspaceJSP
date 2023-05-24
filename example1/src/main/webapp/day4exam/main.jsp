<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<jsp:useBean id="login" class="day4exam.LoginBean"/>
<jsp:setProperty property="id" name="login"/>
<jsp:setProperty property="password" name="login"/>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<jsp:getProperty property="id" name="login"/>님이 로그인했습니다.
	<br />
	<form method="post" action="./logout.jsp">
		<input type="submit" value="로그아웃">
	</form>
</body>
</html>