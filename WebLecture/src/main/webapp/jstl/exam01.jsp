<%@page import="book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	BookVO book = new BookVO("123-456", "JSTL", " ");

	pageContext.setAttribute("book", book);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ISBN : ${ book.isbn } <br>
	title : <a href="../el/exam06_sol.jsp"> <c:out value = "${ book.title }" /> </a> <br>
	writer : ${ book.writer } <br>
</body>
</html>