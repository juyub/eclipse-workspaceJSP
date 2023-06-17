<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
table {
	border-collapse: collapse;
}

td {
	padding: 5px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="../topMenu.jsp" />
	</header>
	<section>
		<h1>게시글 목록</h1>
		<hr>
		<button> <a href="insertBoard.jsp"> 글 작성 </a> </button>
		<button> <a href="getBoardList.do"> 전체글 </a> </button>
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
			<input type="text" name="writer"> <input type="submit" value="검색">
		</form>
	</section>
	
</body>
</html>
