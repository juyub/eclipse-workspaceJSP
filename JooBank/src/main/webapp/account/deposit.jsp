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
<form action="${contextPath}/deposit.do" method="post">
계좌 : <input type="text" name="ac_number" value= "${account.ac_number}" readonly> <br>
현재잔액 : <input type="text" name="AC_MONEY" value= "<fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" />" readonly> <br>
예금주 : <input type="text" name="name" value= "${account.name}" readonly> <br>
입금액 : 	<input type="text" name="depositAmount" value="입금"> 원 <br>				
<input type="submit" >
</form>
</body>
</html>