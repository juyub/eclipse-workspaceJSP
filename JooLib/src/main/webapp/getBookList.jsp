<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>�Խñ� ���</h1>
<hr>
<h3>${ user.name }�� ȯ���մϴ�. <button> <a href="logout.do"> logout </a> </button></h3>
<button> <a href="insertBoard.html"> �� �ۼ� </a> </button>
<button> <a href="getBoardList.do"> ��ü�� </a> </button>
<br><br>
<table border="1">
	<tr>
		<td>no. </td><td>title</td><td>writer</td><td>date</td><td>hit</td>
	</tr>
	<c:forEach var="book" items="${ bookList }" >
	<tr>
		<td>${ book.bookno }</td>
		<td><a href="getBook.do?seq=${ book.bookno }">${ book.title }</a></td>
		<td>${ book.author } </td>
		<td>${ book.publisher } </td>
		<td>${ book.category } </td>
	</tr>
	</c:forEach>
</table>
<br>
<form action="searchBoard.do" method="post">
	<input type="text" name="writer"> <input type="submit" value="�˻�">
</form>
</body>
</html>
