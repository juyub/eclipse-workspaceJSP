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
<br>
	<%
	Boolean isValidCredentials = (Boolean) session.getAttribute("isValidCredentials");

	if (isValidCredentials != null && isValidCredentials) {
		response.sendRedirect("main.jsp");
	}
	%>
	<form method="post" action="/example1/LogInServlet">
		id <input type="text" name="id"> <br>
		pw <input type="password" name="pw"> <br>	
		<input type="submit">
	</form>
</body>
</html>
