<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />     
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create Account</title>
</head>
<body>
  <h1>Create Account</h1>
  <form action="${contextPath}/createAccount.do" method="post">
    <table>
      <tr>
        <td>이름</td>
        <td>
        	<input type="text" name="name" value="${login.name}" readonly>
        	<input type="hidden" name="memberNO" value="${login.memberNO}">
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td><input type="password" name="accountPassword" maxlength="4" required></td>
      </tr>
      <tr>
        <input type="hidden" name="bankCode" maxlength="3" value="3">
        <td colspan="2"><input type="submit" value="Create Account"></td>
      </tr>
    </table>
  </form>
</body>
</html>
