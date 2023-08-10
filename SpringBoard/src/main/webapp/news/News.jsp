<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table {
	border-collapse: collapse;
}
td {
	padding: 5px;
}
a {
  text-decoration: none;
  color: inherit;
}
section {
  margin-left: 5%;
  margin-right: 5%;
  padding: 20px;
}
</style>
</head>
<body>

	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	
	<section>
		<h1>뉴스 목록</h1>
		<br><br>
			<c:forEach var="news" items="${newsList}">
		<table border="0" style="width: 60%;">
				<tr>
					<td ><a href="${news.link}">${news.title}</a></td>
				</tr>
				<tr>
					<td align="right">${news.pubDate}</td>
				</tr>
		</table>
			</c:forEach>
	</section>
	
</body>
</html>
