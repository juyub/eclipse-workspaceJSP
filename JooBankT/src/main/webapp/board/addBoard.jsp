<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<header>
			<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<h1>새글 등록</h1>
		<hr>
		<form action="insertBoard.do" method="post">
		<table>
			<tr>
				<td> 제목 </td>
				<td> <input type="text" name="title"/> </td>
			</tr>
			<tr>
				<td> 작성자 </td>
				<td> <input type="text" name="writer" value="${ login.name }" readonly/> </td>
			</tr>
			<tr>
				<td> 글 내용 </td>
				<td> <textarea name="content" cols="40" rows="10"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등록"/></td>
			</tr>
		</table>
		</form>
	</section>
</body>
</html>