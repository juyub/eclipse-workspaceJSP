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
<link rel="stylesheet" href="/WebTest/css/layout.css">
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

		/*
		let id = document.getElementById("id")
		if(id.value == '') {
			alert('ID를 입력하세요')
			id.focus()
			return false
		}
		 */

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
<link rel="stylesheet" href="/MyLib/css/login.css">
<style>
html{
	background: url("/MyLib/image/wall.jpg");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
}
#login-box {
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
</style>
</head>
<body>

	<div id="login-box" align="center">
		<h2>로그인</h2>
		<br>
		<form method="post" action="loginProcess.jsp" name="loginForm"
			onsubmit="return checkForm()">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" name="id">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" name="password">
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>

</body>
</html>
