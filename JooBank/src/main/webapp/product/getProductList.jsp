<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/JooBank/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section style="display: flex; flex-direction: column; align-items: center;">
		<c:if test="${ login.user_type eq 'admin' }">
		<button><a href="${contextPath}/product/addProduct.jsp">상품등록</a></button><br>
		</c:if>
		<c:forEach var="product" items="${productList}" >
			<a href="${contextPath}/getProduct.do?pd_number=${product.pd_number}">
				<table border="1">
					<tr>
						<td >${product.pd_name}</td>
					</tr>
					<tr>
						<td >${product.pd_content}</td>
					</tr>
					<tr>
						<td >만기 ${product.pd_ed_date}년</td>
					</tr>
				</table>
			</a>
		</c:forEach>
	</section>
</body>
</html>