<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/transfer.do" method="post" onsubmit="return onSubmitForm(this);">
예금주 : ${account.name} <br>
이체할 은행 : ${account.bank_name} <br>
이체할 금액 : <input type="text" name="transferAmount" value="${transferAmount}"> 원 <br>				
<input type="hidden" name="sendAc_number" value="${sendAc_number}"> <br>
<input type="hidden" name="receivAc_number" value="${account.ac_number}"> <br>
<input type="submit" value="이체">
</body>
</html>