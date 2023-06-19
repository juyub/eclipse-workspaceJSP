<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<script>
	function confirmDelete() {
	    if (confirm("정말로 탈퇴하시겠습니까?")) {
	        location.href = "deleteUser.do?userno=${user.userno}";
	    }
	}
	
	<c:if test="${deleteFailed != null}">
   		alert("대여중인 도서가 있어 탈퇴가 불가합니다");
	</c:if>
	
	function togglePasswordVisibility(id) {
		  var input = document.getElementById(id);
		  if (input.type === "password") {
		    input.type = "text";
		  } else {
		    input.type = "password";
		  }
	}
</script>
<style>
table {
  border-collapse: collapse;
}
td {
  padding: 5px;
}
.side-menu {
    display: flex;
    flex-direction: column;
    position: absolute;
    left: 10%;
    top: 20%;
    margin:5%;
 }

 section {
    display: flex;
    justify-content: center;
 }

 .container {
    display: flex;
 }

 .side-menu ul {
    list-style-type: none;
    padding: 0;
 }

 .side-menu li {
    background-color: rgba(135, 207, 235, 0.85);
    color: #000;
    text-align: center;
    border-radius: 5px;
    padding: 10px;
    margin-bottom: 10px;
    cursor: pointer;
 }

 .side-menu li:hover {
     background-color: orange;
 }
</style>
</head>
<body>
	<header>
		<jsp:include page="../topMenu.jsp" />
	</header>

		<section style="display: flex; justify-content: center;">
	 <div class="container">
		 <div class="side-menu">
      		<ul>
                <li><a href="">회원정보</a></li>
                <li><a href="">계좌정보</a></li>
                <li><a href="">탈퇴하기</a></li>
            </ul>
    	</div>
		<form action="updateMember.do" method="post">
			<table border="1">
				<tr>
					<td>회원번호</td>
					<td><input name="userno" type="text" value="${login.memberNO}"
						readonly /></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" value="${login.memberID}"
						readonly /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					<span>
					<input type="password" name="password" id="password"
						value="${login.password}" /> <br>
					<input type="checkbox" onclick="togglePasswordVisibility('password')"> 비밀번호 보기
					</span>	
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${login.name}"
						readonly /></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" name="phone" value="${login.phone}" /></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td>
						<fmt:formatDate value="${login.joindate}" pattern="yy/MM/dd" var="formattedDate" />
       				 	<input type="text" name="joindate" value="${formattedDate}" readonly />
					</td>
				</tr>
				<tr>
					<td>권한</td>
					<td><input type="text" name="role" value="${login.role}"
						readonly /></td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="submit" value="수정" />
					</td>
				</tr>
			</table>
		</form>
		</div>
	</section>
</body>
</html>
