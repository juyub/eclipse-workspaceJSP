<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
Include Jsp file....
<br>
name : <%= request.getAttribute("name") %>
data : <%= request.getParameter("data") %>
</center>
</body>
</html>