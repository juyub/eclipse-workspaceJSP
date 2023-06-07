<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">

</head>
<body>
	<header>
		<jsp:include page="./topMenu.jsp" />
	</header>
	
	<section>
	
	<form action="updateUser.do" method="post"> 
    <input name="userno" type="hidden" value="${ user.userno }" /> 
    <table border="1"> 
        <tr> 
            <th>아이디</th> 
            <td><input type="text" name="userid" value="${user.userid}" /></td> 
        </tr>
        <tr> 
            <th>패스워드</th> 
            <td><input type="text" name="password" value="${user.password}" /></td> 
        </tr>
        <tr> 
            <th>이름</th> 
            <td><input type="text" name="name" value="${user.name}" /></td> 
        </tr>
        <tr> 
            <th>연락처</th> 
            <td><input type="text" name="phone" value="${user.phone}" /></td> 
        </tr>
        <tr> 
            <th>대출가능권수</th> 
            <td><input type="text" name="borrown" value="${user.borrown}" /></td> 
        </tr>
        <tr> 
            <th>가입일</th> 
            <td><input type="text" name="joindate" value="${user.joindate}" /></td> 
        </tr>
        <tr> 
            <th>권한</th> 
            <td><input type="text" name="role" value="${user.role}" /></td> 
        </tr>
        <%-- <c:if test="${ user.role == 'admin' }">
        </c:if> --%>
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정" />
                    <button><a href="deleteUser.do?userno=${ user.userno }">삭제</a></button>
                </td>
            </tr>
    </table>
							
	</form>
		<!-- <a href="getBookList.do">list</a> -->
		<!-- <button><a href="borrowBook.do">대출</a></button> -->
		<button><a href="getBookList.do">뒤로가기</a></button>
	</section>
	
</body>
</html>
