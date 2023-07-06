<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<style>
.l-image {
   width: 80px;
}
a {
  text-decoration: none;
  color: inherit;
}
</style>

<table style="width:90%" align="center" border="1">
  <tr>
  	<td style="width: 80px;">
  	<a href="${contextPath}/index">
  	<img src="/SpringBoard/image/user.png" class="l-image" alt="로고"></a>
  	</td>
    <td align="center">
    <a href="index" class="link-spacing">게시판</a>
    </td>
  </tr>
</table>
