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
<script>
	function showAlertAndRedirect() {
		alert('접근 권한이 없습니다.');
		location.href = "indexPage.do";
	}
</script>
<style>
	.bottom-line td {
		border-bottom: 1px solid black;
	}
</style>
</head>
<body>
	<c:if test="${ login.role == 'admin'}">
		<header>
			<jsp:include page="/topMenu.jsp" />
		</header>
		<section>
			<table class="bottom-line">
				<tr>
					<td>no</td>
					<td>도서</td>
					<td>아이디</td>
					<td>대출일</td>
					<td>만료일</td>
					<td>반납일</td>
				</tr>
				<c:forEach var="borrow" items="${ borrowList }">
					<tr class="bottom-line">
						<form action="returnBook.do" method="post">
							<td>${ borrow.borrowno }</td>
							<td>${ borrow.booktitle }</td>
							<td>${ borrow.username }</td>
							<td>
							<fmt:formatDate value="${ borrow.borrowdate }" pattern="yy/MM/dd" var="formattedBorrowDate" />
							${formattedBorrowDate}
							</td>
							<td>
							<fmt:formatDate value="${borrow.duedate}" pattern="yy/MM/dd" var="formattedDueDate" />
							${formattedDueDate}
							</td>
							<c:if test="${borrow.returndate == null}">
								<td>
									미반납
								</td>
							</c:if>
							<c:if test="${borrow.returndate != null}">
								<td>
									<fmt:formatDate value="${borrow.returndate}" pattern="yy/MM/dd" var="formattedReturnDate" />
									${formattedReturnDate}
								</td>
							</c:if>
							<c:if test="${borrow.returndate == null}">
								<td>
								<input name="userno" type="hidden" value="${ borrow.userno }">
								<input name="bookno" type="hidden" value="${ borrow.bookno }">
								<input name="borrowno" type="hidden" value="${ borrow.borrowno }">
								<input	type="submit" value="반납">
								</td>
							</c:if>
						</form>
					</tr>
				</c:forEach>
			</table>
		</section>
	</c:if>
	<c:if test="${ login.role != 'admin'}">
		<script>
			showAlertAndRedirect();
		</script>
	</c:if>
</body>
</html>