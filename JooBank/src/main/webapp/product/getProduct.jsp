<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath}/updateProduct.do" method="post">
	<table>
	<tr>
		<td>
		상품번호
		</td>
		<td>
		${product.pd_number}
		<input type="hidden" name="pd_number" value="${product.pd_number}">
		</td>
	</tr>
	<tr>
		<td>
		상품명
		</td>
		<td>
		<input type="text" name="pd_name" value="${product.pd_name}"> 
		</td>
	</tr>
	<tr>
		<td>
		상품설명
		</td>
		<td>
		<input type="text" name="pd_content" value="${product.pd_content}">
		</td>
	</tr>
	<tr>
	<button><a href="${contextPath}/createAccountPage.do?pd_number=${product.pd_number}">계좌개설하기</a></button>
	</tr>
	<tr>
	<input type="submit">
	</tr>
	</table>
	</form>
</body>
</html>