<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금융송금</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="/JooBank/css/main.css">
<style>
#checkAc_numberDialog {
	display: none;
}
</style>
</head>
<body>
<body>
	<header>
		<jsp:include page="../topMenu.jsp" />
	</header>
	<section style="display: flex; justify-content: center;">

		<form id="transferForm" action="${contextPath}/obTransfer.do"
			method="post" > <!-- onSubmit="return onSubmitForm(this);" -->
			<table border="1">
				<tr>
					<td>송금계좌</td>
					<td><input type="text" name="sendAc_number"
						value="${account.ac_number}" readonly>
						<input type="hidden" name="sendBank_cd" value="${account.bank_cd}"></td>
				</tr>
				<tr>
					<td>계좌잔액</td>
					<td><input type="text" name="AC_MONEY"
						value="<fmt:formatNumber type='number' pattern='###,###' value='${account.AC_MONEY}' />"
						readonly></td>
				</tr>
				<tr>
					<td>예금주</td>
					<td><input type="text" name="name" value="${account.name}"
						readonly></td>
				</tr>
				<tr>
					<td>이체할 은행</td>
					<td>
					<select name="selected_bank_cd" onchange="updateSelectedBankCd(this)">
				        <c:forEach items="${bankList}" var="bank">
				          <option value="${bank.bank_cd}">${bank.bank_name}</option>
				        </c:forEach>
				      </select>
					</td>
				</tr>
				<tr>
					<td>이체할 계좌</td>
					<td>
					<input type="text" id="receivAc_number"	name="receivAc_number"></td>
				</tr>
				<tr>
					<td>이체할 금액</td>
					<td>
					<input type="text" name="transferAmount" onkeyup="formatInput(this);"> 원</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" id="transfer" value="이체"></td>
				</tr>
			</table>
		</form>
	</section>

</body>
</html>
