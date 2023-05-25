<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String [ ] nameArray = { "홍길동", "임꺽정", "강감찬" };
	
	pageContext.setAttribute("names", nameArray);

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	첫번째 이름 : <%= nameArray[0] %> <br>
	첫번째 이름 : <%= ((String[])pageContext.getAttribute("names"))[0] %> <br>
	
	EL 첫번째 이름 : ${ names[0] } <br>
	EL 첫번째 이름 : ${ names[4] } <br>
	
</body>
</html>