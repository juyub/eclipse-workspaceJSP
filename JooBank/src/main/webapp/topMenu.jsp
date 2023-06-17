<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<link rel="stylesheet" type="text/css" href="css/topmenu.css">

<script>
function toggleSubMenu(show) {
    var submenu = document.getElementById('submenu4');
    submenu.style.display = show ? 'block' : 'none';
}
</script>

<table style="width:90%" align="center" >
  <tr>
    <td class="cell1">
      <img src="/JooBank/image/logoicon.png" class="l-image" alt="로고">
    </td>
    <td class="cell2" align="center">
      <c:if test="${ not empty login }">
        <a href="getBorrowList.do" class="link-spacing">계좌</a>
    <a href="getBookList.do" class="link-spacing">오픈뱅킹</a>
    <a href="getBoardList.do" class="link-spacing">게시판</a>
      </c:if>
    </td>
    <td class="cell3" align="center">
      <c:if test="${ not empty login }">
      ${ login.name }(${ login.userid })님 <br>
      로그인중...
      </c:if>
    </td>
    <td class="cell4" align="center">
      <ul>
        <li id="menu4" onmouseover="toggleSubMenu(true)" onmouseout="toggleSubMenu(false)">
          <img src="/JooBank/image/login.png" id="li-image" alt="로고">
          <ul id="submenu4">
            <c:choose>
              <c:when test="${ empty login }">
                <li><a href="addUserPage.do">회원가입</a></li>
                <li><a href="${ pageContext.request.contextPath }/login/login.jsp">로그인</a></li>
              </c:when>
              <c:otherwise>
                <li><a href="getUserMy.do">마이페이지</a></li>
                <li><a href="logout.do">로그아웃</a></li>
              </c:otherwise>
            </c:choose>
          </ul>
        </li>
      </ul>
    </td>
  </tr>
</table>

