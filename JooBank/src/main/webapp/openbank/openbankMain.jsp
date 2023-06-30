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
<link rel="stylesheet" type="text/css" href="/JooBank/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="../topMenu.jsp" />
	</header>
	<section>
		<%-- <c:choose>
			 <c:when test="${ empty nsAcList }"> 
		 		계좌가 없습니다.
		 	</c:when>
			  <c:otherwise>
				<c:forEach var="account" items="${ nsAcList }">
					<table border="1">
						<tr>
						<td>
						<button><a href="${contextPath}/obTransferPage.do?ac_number=${ account.ac_number }&bank_cd=${account.bank_cd}">이체</a></button>
						</td>
						<td>
						${ account.AC_OP_DATE }
						</td>
						<td>
						${ account.AC_ED_DATE }
						</td>
						</tr>
						<tr>
							<td>${ account.bank_name }</td>
							<td>${ account.pd_name }</td>
							<td>${ account.name }</td>
						</tr>
						<tr>
							<td ><a href="${contextPath}/getAc_recordList.do?ac_number=${ account.ac_number }">${ account.ac_number }</a></td>
							<td COLSPAN="2" align="right" style="width:250px">
							 잔액 : <fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" /> 원
							 </td>
						</tr>
					</table>
				</c:forEach>
			</c:otherwise>
		</c:choose> --%>
		<c:choose>
			<c:when test="${ empty bhAcList }"> 
		 		계좌가 없습니다.
		 	</c:when>
			<c:otherwise>
				<c:forEach var="account" items="${ bhAcList }">
					<table border="1">
						<tr>
						<td>
						<button><a href="${contextPath}/obTransferPage.do?ac_number=${ account.ac_number }&bank_cd=${account.bank_cd}">이체</a></button>
						</td>
						<td>
						${ account.AC_OP_DATE }
						</td>
						<td>
						${ account.AC_ED_DATE }
						</td>
						</tr>
						<tr>
							<td>${ account.bank_name }</td>
							<td>${ account.pd_name }</td>
							<td>${ account.name }</td>
						</tr>
						<tr>
							<td ><a href="${contextPath}/getAc_recordList.do?ac_number=${ account.ac_number }">${ account.ac_number }</a></td>
							<td COLSPAN="2" align="right" style="width:250px">
							 잔액 : <fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" /> 원
							 </td>
						</tr>
					</table>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${ empty plAcList }"> 
		 		계좌가 없습니다.
		 	</c:when>
			<c:otherwise>
				<c:forEach var="account" items="${ plAcList }">
					<table border="1">
						<tr>
						<td>
						<button><a href="${contextPath}/obTransferPage.do?ac_number=${ account.ac_number }&bank_cd=${account.bank_cd}">이체</a></button>
						</td>
						<td>
						${ account.AC_OP_DATE }
						</td>
						<td>
						${ account.AC_ED_DATE }
						</td>
						</tr>
						<tr>
							<td>${ account.bank_name }</td>
							<td>${ account.pd_name }</td>
							<td>${ account.name }</td>
						</tr>
						<tr>
							<td ><a href="${contextPath}/getAc_recordList.do?ac_number=${ account.ac_number }">${ account.ac_number }</a></td>
							<td COLSPAN="2" align="right" style="width:250px">
							 잔액 : <fmt:formatNumber type="number" pattern="###,###" value="${account.AC_MONEY}" /> 원
							 </td>
						</tr>
					</table>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</section>
</body>
</html>