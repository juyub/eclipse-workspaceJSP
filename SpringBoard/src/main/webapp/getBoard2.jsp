<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<br>
	<button><a href="javascript:history.back()">뒤로가기</a></button>
	<br><br>
	<form action="updateBoard" method="post">
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
				<td>
				<textarea name="content" cols="40" rows="10">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><fmt:formatDate value="${board.regDate}" pattern="yy/MM/dd HH:mm:ss"/></td>
			</tr>
			<%-- <tr>
				<th>조회수</th>
				<td><input type="text" name="hit" value="${board.hit}" readonly/></td>
			</tr> --%>
			<tr>
				<td colspan="2">
				<input type="submit" value="수정" />
				<button><a href="deleteBoard?seq=${ board.seq }">삭제</a></button>
				</td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>
