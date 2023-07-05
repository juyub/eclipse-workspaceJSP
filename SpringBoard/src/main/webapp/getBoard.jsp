<%@page import="board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<form action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${ board.seq }">
		<table border="1">
			<%-- <tr>
	            <th>번호</th>
	            <td>${board.seq}</td>
	        </tr> --%>
			<tr>
				<th>제목</th>
				<td><input name="title" type="text" value="${board.title}"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" cols="40" rows="10">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${board.regDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><input type="text" name="hit" value="${board.hit}" readonly/></td>
			</tr>
			
			<c:if test="${user.name eq board.writer}">
			<tr>
				<td colspan="2"><input type="submit" value="수정" /></td>
			</tr>
			</c:if>
		</table>
		<c:if test="${ user.role == 'Admin' }">
		<a href="deleteBoard.do?seq=${ board.seq }">delete</a>
		</c:if>
		<!-- <a href="getBoardList.do">list</a> -->
	</form>
		<button><a href="javascript:history.back()">뒤로가기</a></button>
	</section>
</body>
</html>
