<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<style>
hr{
border-color: transparent;
padding:0;
magin:0;
}
</style>

<table style="width:100%" >
	<tr>
		<td rowspan="2" align="center">로고</td>
		<td align="right">
			환영합니다
			<c:if test="${ not empty login }">
			[${ login.name }(${ login.userid })님 로그인중...]
			</c:if>
		</td>
	</tr>
	<tr>
		<td align="right">
			<a href="getBookList.do">도서목록</a> |
			<c:if test="${ login.role eq 'admin' }">
				<a href="getBorrowList.do">대출현황</a> |
				<a href="getUserList.do"> 회원목록</a> |
			</c:if>
			 <!-- 게시판 | -->
			<c:if test="${ login.role eq 'user' }">
			 	<a href="getBorrowUser.do">대출내역</a> | 
			 	<a href="getUserMy.do">마이페이지</a> | 
			</c:if>
			<c:choose> 
				<c:when test="${ empty login }"> 
			 		<a href="/JooLib/addUser.jsp">회원가입</a> | 
			 		<a href="loginPage.do">로그인</a>
			 	</c:when>
			 	<c:otherwise> 
			 		<a href="logout.do">로그아웃</a>
			 	</c:otherwise>
			</c:choose>  
		</td>
	</tr>
</table>
<hr>






