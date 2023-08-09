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
<!-- <link rel="stylesheet" type="text/css" href="css/main.css"> -->

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
		<h1>게시글 목록</h1>
		<button>
			<a href="addBoard"> 글 작성 </a>
		</button>
		<br>
		<br>
		<table border="1">
			<tr align="center">
				<td >no</td>
				<td align='left' style="padding-left: 30px">title</td>
				<td >writer</td>
				<td >date</td>
				<!-- <td>hit</td> -->
			</tr>
			<c:choose>
            <c:when test="${empty boardList}">
                <tr height="10">
                    <td colspan="5">
                        <p align="center">
                            <b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
                        </p>
                    </td>
                </tr>
            </c:when>
            <c:when test="${!empty boardList}">
                <c:forEach var="board" items="${boardList}" varStatus="boardNum">
                    <tr align="center">
                        <td width="5%">${boardNum.count}</td>
                        <td align='left' width="35%">
						  <c:choose>
						    <c:when test='${board.level > 1 }'>
						      <c:forEach begin="1" end="${board.level }" step="1">
						        <span style="padding-left: 20px"></span>
						      </c:forEach>
						      <span style="font-size: 12px;">[답변]</span>
						      <a class='cls1'
						          href="${contextPath}/getBoard?seq=${board.seq}">${board.title}</a>
						    </c:when>
						    <c:otherwise>
						      <span style="padding-right: 25px"></span>
						      <a class='cls1'
						          href="${contextPath}/getBoard?seq=${board.seq}">${board.title }</a>
						    </c:otherwise>
						  </c:choose>
                        </td>
                        <td width="10%">${board.writer}</td>
                        <td width="15%"><fmt:formatDate value="${board.regDate}" pattern="yy/MM/dd HH:mm:ss"/></td>
                       <%--  <td width="10%">${board.hit}</td> --%>
                    </tr>
                </c:forEach>
            </c:when>
        </c:choose>
		</table>
		
		<br>
	
		<!-- 페이징 처리 -->
		<div>
			<!-- 이전 버튼 추가 -->
			<c:if test="${pageNumber > 1}">
				<a href="${contextPath}/getBoardList?pageNumber=${pageNumber - 1}">이전</a>
			</c:if>

			<c:forEach var="i" begin="1" end="${totalPage}">
				<c:choose>
					<c:when test="${pageNumber == i}">
						<b>${i}</b>
					</c:when>
					<c:otherwise>
						<a href="${contextPath}/getBoardList?pageNumber=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<!-- 다음 버튼 추가 -->
			<c:if test="${pageNumber < totalPage}">
				<a href="${contextPath}/getBoardList?pageNumber=${pageNumber + 1}">다음</a>
			</c:if>
		</div>
	</section>

</body>
</html>
