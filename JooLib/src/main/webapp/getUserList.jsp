<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<header>
		<jsp:include page="./topMenu.jsp" />
	</header>
	<section>
		<table border="1">
			<tr>
				<td>no.</td>
				<td>title</td>
				<td>writer</td>
				<td>date</td>
				<td>hit</td>
			</tr>
			<c:forEach var="user" items="${ userList }">
				<tr>
					<td>${ user.userno }</td>
					<td><a href="getUserNo.do?userno=${ user.userno }">${ user.userid }</a></td>
					<td>${ user.name }</td>
					<td>${ user.phone }</td>
					<td>${ user.joindate }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<!-- <form action="searchBook.do" method="post">
			<select name="searchBy" id="searchBy">
				<option value="title">제목</option>
				<option value="author">작가</option>
			</select>
			<input type="text" name="search">
			<input type="submit" value="검색">
		</form> -->
	</section>

</body>
</html>