<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<table style="width:100%" border="1">
	<tr>
		<td rowspan="2" align="center">로고</td>
		<td align="right">
			환영합니다
			<!-- <span style="padding-right: 5px">즐겨찾기</span> -->
			<c:if test="${ not empty user }">
			[${ user.name }(${ user.userid })님 로그인중...]
			</c:if>
		</td>
	</tr>
	<tr>
		<td align="right">
			<c:if test="${ user.role eq 'admin' }">
				<a href="getBorrowList.do">대출현황</a> |
				회원관리 |
				<a href="/JooLib/addBook.jsp">도서등록</a> |
			</c:if>
			<a href="getBookList.do">도서목록</a> |
			 게시판 |
			<c:choose> 
				<c:when test="${ empty user }"> 
			 		<a href="/JooLib/addUser.jsp">회원가입</a> | 
			 		<a href="loginPage.do">로그인</a> |
			 	</c:when>
			 	<c:otherwise> 
			 		마이페이지 | 
			 		<a href="logout.do">로그아웃</a>
			 	</c:otherwise>
			</c:choose>  
		</td>
	</tr>
</table>








