<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script>
	function confirmDelete() {
	    if (confirm("정말로 탈퇴하시겠습니까?")) {
	        location.href = "deleteUser.do?userno=${user.userno}";
	    }
	}
	
	<c:if test="${deleteFailed != null}">
   		alert("대여중인 도서가 있어 탈퇴가 불가합니다");
	</c:if>
</script>
<style>
table {
  border-collapse: collapse;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="./topMenu.jsp" />
	</header>

	<section>
		<button>
			<a href="javascript:history.back()">뒤로가기</a>
		</button>
		<br> <br>
		<form action="updateUser.do" method="post">
			<table border="1">
				<tr>
					<th>회원번호</th>
					<td><input name="userno" type="text" value="${user.userno}"
						readonly /></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userid" value="${user.userid}"
						readonly /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password"
						value="${user.password}" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${user.name}"
						readonly /></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" name="phone" value="${user.phone}" /></td>
				</tr>
				<tr>
					<th>대출가능권수</th>
					<td><input type="text" name="borrown" value="${user.borrown}"
						readonly /></td>
				</tr>
				<tr>
					<th>가입일</th>
					<td>
						<fmt:formatDate value="${user.joindate}" pattern="yy/MM/dd" var="formattedDate" />
       				 	<input type="text" name="joindate" value="${formattedDate}" readonly />
					</td>
				</tr>
				<tr>
					<th>권한</th>
					<td><input type="text" name="role" value="${user.role}"
						readonly /></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="수정" />
					</td>
				</tr>
			</table>
 		
		</form>
		<br>
		<button onClick="confirmDelete()">탈퇴</button>
	</section>
</body>
</html>
