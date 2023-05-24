<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="login" class="day4exam.LoginBean"/>
<jsp:setProperty property="id" name="login"/>
<jsp:setProperty property="password" name="login"/>
<%
if(login.dbCheck()){
%>
<jsp:forward page="./main.jsp"/>
<%
}else{
%>
<jsp:forward page="./error.jsp"/>
<%
}
%>
</body>
</html>