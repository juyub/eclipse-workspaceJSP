<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/JooBankT/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<button><a href="${contextPath}/account/createAccount.jsp">계좌개설하기</a></button>
		<br> <br>
		<c:choose>
				<c:when test="${ empty accountList }"> 
			 		계좌가 없습니다.
			 	</c:when>
				<c:otherwise>
					<c:forEach var="account" items="${ accountList }">
						<table border="1">
							<tr>
							<td>
							<button><a href="${contextPath}/depositPage.do?accountID=${ account.accountID }">입금</a></button>&nbsp;&nbsp;
							<button><a href="${contextPath}/withdrawPage.do?accountID=${ account.accountID }">출금</a></button>&nbsp;&nbsp;
							<button><a href="${contextPath}/trasferPage.do?accountID=${ account.accountID }">이체</a></button>
							</td>
							<td>
							${ account.openedDate }
							</td>
							</tr>
							<tr>
								<td>${ account.bankName }</td>
								<td>${ account.name }</td>
								<td></td>
							</tr>
							<tr>
								<td ><a href="getBook.do?bookno=${ account.accountID }">${ account.accountID }</a></td>
								<td COLSPAN="2" align="right" style="width:250px">
								 잔액 : <fmt:formatNumber type="number" pattern="###,###" value="${account.balance}" /> 원
								 </td>
							</tr>
						</table>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		
	</section>
</body>
</html>