<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록창</title>
<style>
table {
	border-collapse: collapse;
}
td {
	padding: 5px;
}
.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 20px;
}
</style>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
<section>
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="lightgreen">
			<td>글번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		<c:choose>
			<c:when test="${empty boardList }">
				<tr height="10">
					<td colspan="4">
						<p align="center">
							<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
						</p>
					</td>
				</tr>
			</c:when>
			<c:when test="${!empty boardList}">
				<c:forEach var="board" items="${boardList }" varStatus="boardNum">
					<tr align="center">
						<td width="5%">${boardNum.count}</td>
						<td width="10%">${board.memberID }</td>
						<td align='left' width="35%">
						  <c:choose>
						    <c:when test='${board.level > 1 }'>
						      <c:forEach begin="1" end="${board.level }" step="1">
						        <span style="padding-left: 25px"></span>
						      </c:forEach>
						      <span style="font-size: 12px;">[답변]</span>
						      <a class='cls1'
						          href="${contextPath}/getBoard.do?boardNO=${board.boardNO}">${board.title}</a>
						    </c:when>
						    <c:otherwise>
						      <span style="padding-right: 30px"></span>
						      <a class='cls1'
						          href="${contextPath}/getBoard.do?boardNO=${board.boardNO}">${board.title }</a>
						    </c:otherwise>
						  </c:choose>
						</td>
						<%-- <td align='left' width="35%">
							<span style="padding-right: 30px"></span>
								<c:choose>
									<c:when test='${board.level > 1 }'>
										<c:forEach begin="1" end="${board.level }" step="1">
											<span style="padding-left: 20px"></span>
										</c:forEach>
										<span style="font-size: 12px;">[답변]</span>
										<a class='cls1'
											href="${contextPath}/getBoard.do?boardNO=${board.boardNO}">${board.title}</a>
									</c:when>
									<c:otherwise>
										<a class='cls1'
											href="${contextPath}/getBoard.do?boardNO=${board.boardNO}">${board.title }</a>
									</c:otherwise>
								</c:choose>
						</td> --%>
						<td width="10%"><fmt:formatDate value="${board.regdate}" /></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a class="cls1" href="${contextPath}/board/addBoard.jsp"><p class="cls2">글쓰기</p></a>
</section>
</body>
</html>