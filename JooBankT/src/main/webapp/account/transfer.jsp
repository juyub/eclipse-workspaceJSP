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
<form action="${contextPath}/transfer.do" method="post">
송금계좌 : <input type="text" name="sourceAccountID" value= "${account.accountID}" readonly> <br>
계좌잔액 : <input type="text" name="balance" value= "<fmt:formatNumber type="number" pattern="###,###" value="${account.balance}" />" readonly> <br>
예금주 : <input type="text" name="name" value= "${account.name}" readonly> <br>
<br>
이체할 은행 :  <br>
이체할 계좌 : <input type="text" name="targetAccountID"> <br>
이체할 금액 : 	<input type="text" name="transferAmount" > 원 <br>				
<input type="submit" value="이체">
</form>
</body>
</html>