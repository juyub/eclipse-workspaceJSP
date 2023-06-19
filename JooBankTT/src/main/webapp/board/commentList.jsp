<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 목록</title>
</head>
<body>
    <table border="1" align="center" width="60%">
        <tr>
            <td colspan="2">
                <strong>댓글 목록</strong>
            </td>
        </tr>
        <c:forEach var="comment" items="${commentList}">
            <tr>
                <td>${comment.memberID}: ${comment.content}</td>
                <td>작성일: <fmt:formatDate value="${comment.regdate}" pattern="yyyy/MM/dd"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
