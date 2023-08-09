<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/main.css">
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
		removeCommas(form.depositAmount);
		return true;
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="../topMenu.jsp" />
	</header>
	<section style="display: flex; justify-content: center;">
		<form action="${contextPath}/deposit.do" method="post"
			onsubmit="return onSubmitForm(this);">
			<table border="1">
				<tr>
					<td>계좌</td>
					<td><input type="text" name="ac_number"
						value="${account.ac_number}" readonly>
						<input type="hidden" name="bank_cd" value="${account.bank_cd}"></td>
				</tr>
				<tr>
					<td>현재잔액</td>
					<td><input type="text" name="AC_MONEY"
						value="<fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" />"
						readonly></td>
				</tr>
				<tr>
					<td>예금주</td>
					<td><input type="text" name="name" value="${account.name}"
						readonly></td>
				</tr>
				<tr>
					<td>입금액</td>
					<td><input type="text" name="depositAmount"
						onkeyup="formatInput(this);"> 원</td>
				</tr>
				<tr>
					<td>메모</td>
					<td><input type="text" name="rc_text"></td>
				</tr>
				<tr>
					<td><input type="submit"></td>
					<td></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>