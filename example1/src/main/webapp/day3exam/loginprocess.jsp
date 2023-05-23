<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.io.BufferedReader,java.io.FileReader"%>
<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");

String filePath = "C:\\JSPSDK\\IDPW.txt";
boolean isValidCredentials = false;
BufferedReader br = null;

if (id != null && pw != null) {
	br = new BufferedReader(new FileReader(filePath));
	String line;
	while ((line = br.readLine()) != null) {
		String[] parts = line.split(" ");
		if (parts.length == 2) {
	String storedId = parts[0];
	String storedPw = parts[1];
	if (storedId.equals(id) && storedPw.equals(pw)) {
		isValidCredentials = true;
		break;
	}
		}
	}

	if (br != null) {
		br.close();
	}
}

if (isValidCredentials) {
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("isValidCredentials", true);

	response.sendRedirect("main.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제목을 입력하세요</title>
</head>
<body>

</body>
</html>
<%
} else {
response.sendRedirect("error.jsp");
}
%>
