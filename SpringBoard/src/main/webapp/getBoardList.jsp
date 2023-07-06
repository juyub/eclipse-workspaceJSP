<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/main.css"> -->
<style>
table {
	border-collapse: collapse;
}
td {
	padding: 5px;
}
a {
  text-decoration: none;
  color: inherit;
}
section {
  margin-left: 5%;
  margin-right: 5%;
  padding: 20px;
}
</style>
</head>
<body>

	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	
	<section>
		<h1>게시글 목록</h1>
		
		<table border="1">
			<tr>
				<td>no. </td><td>title</td><td>writer</td><td>date</td><!-- <td>hit</td> -->
			</tr>
			<c:forEach var="board" items="${ data }" >
				<tr>
					<td>${ board.seq }</td>
					<td style="width: 35%;"><a href="getBoard?seq=${ board.seq }">${ board.title }</a></td>
					<td>${ board.writer } </td>
					<td><fmt:formatDate value="${ board.regDate }" pattern="yy/MM/dd HH:mm:ss"/></td>
					<%-- <td>${ board.hit } </td> --%>
				</tr>
			</c:forEach>
		</table>
		
	</section>
	
</body>
</html>
