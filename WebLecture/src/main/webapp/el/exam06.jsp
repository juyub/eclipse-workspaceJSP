<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
    List<Map<String, String>> books = new ArrayList<>();
    Map<String, String> book = new HashMap<>();
    book.put("title", "����");
    books.add(book);
%>
<%= books.get(0).get("title") %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%-- ���� ��� 4���� ��� --%>
	${ books[0].title }
	

</body>
</html>