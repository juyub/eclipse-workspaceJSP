<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script>
function toggleSubMenu(show) {
    var submenu = document.getElementById('submenu4');
    submenu.style.display = show ? 'block' : 'none';
}
</script>

 <link rel="stylesheet" type="text/css" href="/JooBankT/css/topmenu.css">
 
<table style="width:90%" align="center">
  <tr>
    <td class="cell1">
      <img src="/JooBankT/image/logoicon.png" class="l-image" alt="로고">
    </td>
    <td class="cell2" align="center">
      <c:if test="${ not empty login }">
        <a href="${contextPath}/myAccountList.do" class="link-spacing">계좌</a>
    <a href="getBookList.do" class="link-spacing">오픈뱅킹</a>
    <a href="${contextPath}/getBoardList.do" class="link-spacing">게시판</a>
      </c:if>
    </td>
    <td class="cell3" align="center">
      <c:if test="${ not empty login }">
      ${ login.name }(${ login.memberID })님 <br>
      로그인중...
      </c:if>
    </td>
    <td class="cell4" align="center">
      <ul>
        <li id="menu4" onmouseover="toggleSubMenu(true)" onmouseout="toggleSubMenu(false)">
          <img src="/JooBankT/image/user.png" id="li-image" alt="로고">
          <ul id="submenu4">
            <c:choose>
              <c:when test="${ empty login }">
                <li><a href="/JooBankT/member/join.jsp">회원가입</a></li>
                <li><a href="${contextPath}/loginPage.do">로그인</a></li>
              </c:when>
              <c:otherwise>
                <li><a href="${contextPath}/myPage.do">마이페이지</a></li>
                <li><a href="${contextPath}/logout.do">로그아웃</a></li>
              </c:otherwise>
            </c:choose>
          </ul>
        </li>
      </ul>
    </td>
  </tr>
</table>

