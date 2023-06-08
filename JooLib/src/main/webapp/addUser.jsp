<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
	crossorigin="anonymous"></script>
<script>
	function checkForm() {
		let f = document.loginForm;
		if (f.id.value == '') {
			alert('ID를 입력하세요')
			f.id.focus()
			return false
		}
		if (f.password.value == '') {
			alert('패스워드를 입력하세요')
			f.password.focus()
			return false
		}
		return true
	}
</script>
<style>
.user-box{
width: 400px;
}

#join-table{
 margin : 5%;
}
</style>
<link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>
<div id="user-box" class="user-box" align="center">
<h1> 회원가입 </h1>
<form action="addUser.do" method="post" >
	<table id="join-table">
		<tr>
			<td><label for="id">아이디</label></td>
			<td><input type="text" class="form-control" name="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" class="form-control" name="password"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" class="form-control" name="name"/></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" class="form-control" name="phone"/></td>
		</tr>
	</table>
		<button type="submit" class="btn btn-primary">회원가입</button>
</form>
<br>
<a href="loginPage.do">로그인</a> <br> <br>
<a href="indexPage.do"> 뒤로가기 </a>
</div>
</body>
</html>