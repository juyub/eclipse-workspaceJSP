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
	<c:forEach var="board" items="${ boardList }" >
	<tr>
		<td>${ board.seq }</td>
		<td><a href="getBoard.do?seq=${ board.seq }">${ board.title }</a></td>
		<td>${ board.writer } </td>
		<td>${ board.regDate } </td>
		<td>${ board.hit } </td>
	</tr>
	</c:forEach>
</table>
<br>
<form action="searchBoard.do" method="post">
	<input type="text" name="writer"> <input type="submit" value="�˻�">
</form>
</body>
</html>
