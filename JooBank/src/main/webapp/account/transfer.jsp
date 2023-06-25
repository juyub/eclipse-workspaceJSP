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
<script>
    function numberWithCommas(x) {
        return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    }
    
    function formatInput(input) {
        input.value = numberWithCommas(input.value.replace(/,/g, ''));
    }
    
    function removeCommas(input) {
        input.value = input.value.replace(/,/g, '');
    }

    function onSubmitForm(form) {
        removeCommas(form.transferAmount);
        return true;
    }
    
</script>
</head>
<body>
<form action="${contextPath}/transfer.do" method="post" onsubmit="return onSubmitForm(this);">
송금계좌 : <input type="text" name="sendAc_number" value= "${account.ac_number}" readonly> <br>
계좌잔액 : <input type="text" name="AC_MONEY" value= "<fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" />" readonly> <br>
예금주 : <input type="text" name="name" value= "${account.name}" readonly> <br>
<br>
이체할 은행 :  <br>
이체할 계좌 : <input type="text" name="receivAc_number"> <br>
이체할 금액 : 	<input type="text" name="transferAmount" onkeyup="formatInput(this);"> 원 <br>				
<input type="submit" value="이체">
</form>
</body>
</html>