<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/JooBankT/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<button><a href="${contextPath}/account/createAccount.jsp">계좌개설하기</a></button>
	</section>
</body>
</html>