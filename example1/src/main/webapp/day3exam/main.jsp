<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String sessionID = (String)session.getAttribute("id");
String sessionPW = (String)session.getAttribute("pw");
Boolean sessionValid = (Boolean)session.getAttribute("isValidCredentials");
%>
session : <%= sessionID %><br/>
session : <%= sessionPW %><br/>
session : <%= sessionValid %><br/>
	
	<%--
	String sessionID = (String) session.getAttribute("id");
	--%>

	<h1><%=sessionID%>로 로그인 하였습니다.</h1><br />
	

	<form method="post" action="logout.jsp">
    <input type="submit" value="로그아웃">
</form>
</body>
</html>