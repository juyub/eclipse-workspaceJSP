<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<style>
.b-image {
    width: 20px;
    height: 20px;
}
.l-image {
    width: 80px;
}
</style>

<table style="width:90%" align="center" border="1">
	<tr>
		<td rowspan="2" align="left" >
		<img src="/JooLib/image/libraryb.png" class="l-image" alt="로고">
		</td>
		<td align="center">
			&nbsp;
			<c:if test="${ not empty login }">
			[ ${ login.name }(${ login.userid })님 로그인중... ]
			</c:if>
		</td>
	</tr>
	<tr>
		
		<td align="center">환영합니다</td>
	</tr>
	<tr>
		<td>
		<button>
			<a href="javascript:history.back()">
			<img src="/JooLib/image/back.png" class="b-image" alt="뒤로가기"></a>
		</button>
		<button>
			<a href="indexPage.do">
			<img src="/JooLib/image/home.png" class="b-image" alt="홈"></a>
		</button>
		</td>
		<td align="center">
			<a href="getBookList.do">도서목록</a> |
			<c:if test="${ login.role eq 'admin' }">
				<a href="getBorrowList.do">대출현황</a> |
				<a href="getUserList.do"> 회원목록</a> |
			</c:if>
			  <a href="getBoardList.do"> 게시판 </a> | 
			<c:if test="${ login.role eq 'user' }">
			 	<a href="getBorrowUser.do">대출내역</a> | 
			 	<a href="getUserMy.do">마이페이지</a> | 
			</c:if>
			<c:choose> 
				<c:when test="${ empty login }"> 
			 		<a href="addUserPage.do">회원가입</a> | 
			 		<a href="loginPage.do">로그인</a>
			 	</c:when>
			 	<c:otherwise> 
			 		<a href="logout.do">로그아웃</a>
			 	</c:otherwise>
			</c:choose>  
		</td>
	</tr>
</table>
	





