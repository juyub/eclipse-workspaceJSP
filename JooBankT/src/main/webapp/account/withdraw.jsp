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
<form action="${contextPath}/withdraw.do" method="post">
계좌 : <input type="text" name="accountID" value= "${account.accountID}" readonly> <br>
현재잔액 : <input type="text" name="balance" value= "<fmt:formatNumber type="number" pattern="###,###" value="${account.balance}" />" readonly> <br>
예금주 : <input type="text" name="name" value= "${account.name}" readonly> <br>
출금액 : 	<input type="text" name="withdrawAmount" > 원 <br>				
<input type="submit" value="출금">
</form>
</body>
</html>