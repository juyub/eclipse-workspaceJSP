<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
request.setAttribute("attr", "hello world");
%>
<%= request.getAttribute("attr") %> <br>
${requestScope["attr"]} <br>
${requestScope.attr} <br>
${requestScope["attr2"]} <br>

<%
Map<String, String> map = new HashMap<>();
map.put("one","hello");
map.put("two","world");
pageContext.setAttribute("map", map);
%>
${map.get("one")}, ${map["one"]}, ${map.one }
<br>
${(10*10) ne 100 } <br>
${pageContext.request.contextPath } <br>
${header["host"] }, ${header.host } <br>
</body>
</html>