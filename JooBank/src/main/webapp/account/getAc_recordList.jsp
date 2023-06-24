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
</head>
<body>
	<c:forEach var="record" items="${recordList}" >
		<br>
		<table border="1" width="50%">
		<tr align="center">
			<td >${record.rc_type}</td>
			<td >${record.bank_name}</td>
			<td >${record.rc_name}</td>
			<td width="30%">
			<fmt:formatNumber value="${record.rc_money}" pattern="###,###"/>원</td>
			<td><fmt:formatDate value="${record.rc_time}" pattern="yy/MM/dd HH:mm:ss"/></td>
		</tr>
		</table>
	</c:forEach>
</body>
</html>