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
	<br>
	 <c:choose>
        <c:when test="${currentPage > 1}">
            <a href="${contextPath}/getAc_recordList.do?pageNo=${currentPage-1}&ac_number=${ac_number}">Previous</a>
        </c:when>
        <c:otherwise>
            <span>Previous</span>
        </c:otherwise>
    </c:choose>
    <c:forEach begin="1" end="${totalPageCount}" var="pageNumber">
        <c:choose>
            <c:when test="${pageNumber == currentPage}">
                <span>${pageNumber}</span>
            </c:when>
            <c:otherwise>
                <a href="${contextPath}/getAc_recordList.do?pageNo=${pageNumber}&ac_number=${ac_number}">${pageNumber}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:choose>
        <c:when test="${currentPage < totalPageCount}">
            <a href="${contextPath}/getAc_recordList.do?pageNo=${currentPage+1}&ac_number=${ac_number}">Next</a>
        </c:when>
        <c:otherwise>
            <span>Next</span>
        </c:otherwise>
    </c:choose>
	
</body>
</html>