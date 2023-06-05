<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script>
    function showAlertAndRedirect(){
        alert('접근 권한이 없습니다.');
        location.href = "indexPage.do";
    }
</script>
</head>
<body>
	<c:if test="${ user.role == 'admin'}">
		<header>
			<jsp:include page="/topMenu.jsp" />
		</header>
		<section>
			<table border="1">
				<tr>
					<td>no</td>
					<td>book</td>
					<td>user</td>
					<td>borrow</td>
					<td>due</td>
					<td>return</td>
				</tr>
				<c:forEach var="borrow" items="${ borrowList }">
				<tr>
					<td>${ borrow.borrowno }</td>
					<td>${ borrow.title }</td>
					<td>${ borrow.username }</td>
					<td>${ borrow.borrowdate }</td>
					<td>${ borrow.duedate }</td>
					<td>${ borrow.returndate }</td>
				</tr>
				</c:forEach>
			</table>
		</section>
	</c:if>
	<c:if test="${ user.role != 'admin'}">
		<script>
            showAlertAndRedirect();
        </script>
	</c:if>
</body>
</html>