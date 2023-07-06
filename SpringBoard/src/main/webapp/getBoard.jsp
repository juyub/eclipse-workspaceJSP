<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
	<button><a href="javascript:history.back()">�ڷΰ���</a></button>
	<br><br>
	<form action="updateBoard.do" method="post">
		<input name="seq" type="hidden" value="${ board.seq }">
		<table border="1">
			<%-- <tr>
	            <th>��ȣ</th>
	            <td>${board.seq}</td>
	        </tr> --%>
			<tr>
				<th>����</th>
				<td><input name="title" type="text" value="${board.title}"></td>
			</tr>
			<tr>
				<th>�ۼ���</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>����</th>
				<td><textarea name="content" cols="40" rows="10">${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<th>�ۼ�����</th>
				<td><fmt:formatDate value="${board.regDate}" pattern="yy/MM/dd HH:mm:ss"/></td>
			</tr>
			<%-- <tr>
				<th>��ȸ��</th>
				<td><input type="text" name="hit" value="${board.hit}" readonly/></td>
			</tr> --%>
			
			<c:if test="${user.name eq board.writer}">
			<tr>
				<td colspan="2"><input type="submit" value="����" /></td>
			</tr>
			</c:if>
		</table>
		<c:if test="${ user.role == 'Admin' }">
		<a href="deleteBoard.do?seq=${ board.seq }">delete</a>
		</c:if>
		<!-- <a href="getBoardList.do">list</a> -->
	</form>
	</section>
</body>
</html>
