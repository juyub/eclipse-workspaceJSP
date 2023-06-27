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
</head>
<body>
	<c:forEach var="product" items="${productList}" >
		<a href="${contextPath}/getProduct.do?pd_number=${product.pd_number}"><div>
			<table border="1">
				<tr>
					<td >${product.pd_name}</td>
				</tr>
				<tr>
					<td >${product.pd_content}</td>
				</tr>
				<tr>
					<td >${product.pd_ed_date}</td>
				</tr>
			</table>
		</div></a>
	</c:forEach>
<button><a href="${contextPath}/product/addProduct.jsp">상품등록</a></button>
</body>
</html>