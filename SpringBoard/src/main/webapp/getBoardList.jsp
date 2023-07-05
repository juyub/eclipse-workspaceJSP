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
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<h1>게시글 목록</h1>
		<hr>

		<table border="1">
			<tr>
				<td>no. </td><td>title</td><td>writer</td><td>date</td><td>hit</td>
			</tr>
			<c:forEach var="board" items="${ data }" >
			<tr>
				<td>${ data.seq }</td>
				<td><a href="getBoard.do?seq=${ data.seq }">${ data.title }</a></td>
				<td>${ data.writer } </td>
				<td>${ data.regDate } </td>
				<td>${ data.hit } </td>
			</tr>
			</c:forEach>
		</table>
		
	</section>
	
</body>
</html>
