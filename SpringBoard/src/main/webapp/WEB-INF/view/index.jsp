<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
td {
  padding: 5px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<h1>게시글 목록</h1>
		<hr>

		<table border="1">
			<tr>
				<td>title</td><td>writer</td><td>date</td><td>hit</td>
			</tr>
			<c:forEach var="board" items="${ data }" >
			<tr>
				<td>${ board.title }</a></td>
				<td>${ board.writer } </td>
				<td>${ board.regDate } </td>
				<td>${ board.hit } </td>
			</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>