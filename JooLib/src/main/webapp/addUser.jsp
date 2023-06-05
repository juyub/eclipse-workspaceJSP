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
html{
	background: url("/JooLib/image/wall.jpg");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

body {
	width : 500px;
	padding: 0;
	font-family: verdana, sans-serif;
	font-size: 15px;
	margin: 0 auto;
	margin-top:5%;
}

#join-box {
	position: absolute;
	top: 50%;
	left: 50%;
	padding: 20px;
	transform: translate(-50%, -50%);
	background: rgba(0, 0, 0, .8);
	box-sizing: border-box;
	box-shadow: 0 15px 25px rgba(0, 0, 0, .6);
	border-radius: 10px;
	color: white;
}
#join-table{
margin : 1%;
}
</style>
</head>
<body>
<div id="join-box" align="center">
<h1> 회원가입 </h1>
<form action="addUser.do" method="post">
	<table id="join-table" >
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="phone"/></td>
		</tr>
	</table>
			<input type="submit" name="회원가입"/>
</form>
<br>
<a href="loginPage.do">로그인</a>
</div>
</body>
</html>