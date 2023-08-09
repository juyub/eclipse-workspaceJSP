<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<style>
.l-image {
   width: 80px;
}
a {
  text-decoration: none;
  color: inherit;
}
.link-spacing {
	font-size:25px;
	margin-right: 10px; 
	margin-left: 10px; 
}
</style>

<body>

<table style="width:90%" align="center" border="1">
  <tr>
  	<td style="width: 80px;">
  	<a href="${contextPath}/index">
  	<img src="${contextPath}/image/user.png" class="l-image" alt="로고"></a>
  	</td>
    <td align="center">
    <a href="${contextPath}/getBoardList" class="link-spacing">게시판</a>
    <!-- <a href="getBoardListRest" class="link-spacing">타게시판</a> -->
    </td>
  </tr>
</table>

</body>
</html>