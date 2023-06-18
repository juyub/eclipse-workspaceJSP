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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" type="text/css" href="../css/user.css">
<style>
html{
	background: url("/JooBankTT/image/backWall.jpg");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
}

.user-box {
	width: 400px;
}

#join-table {
	margin: 5%;
}

.btc {
	display: inline-block;
	color: #fff;
	background-color: #007bff;
	margin: 3%;
	border: 1px solid transparent;
	border-radius: 0.25rem;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out, box-shadow .15s ease-in-out;
}

td {
	padding: 5px;
}
</style>

</head>
<body>
	<div id="user-box" class="user-box" align="center">
		<h1>회원가입</h1>
		<form action="${ pageContext.request.contextPath }/join.do" method="post" name="joinForm"
			onsubmit="return checkForm()">
			<table id="join-table">
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" class="form-control" id="id" name="id"
						pattern="[a-z0-9]+" />
						<span class="tip">* 영어 소문자와 숫자.</span></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="button" value="ID중복확인" class="btc"
						onClick="idCheck(this.form.id.value)"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					<span>
					<input type="password" class="form-control" id="password"
						name="password" pattern="[a-z0-9]+" required />
					<input type="checkbox" onclick="togglePasswordVisibility('password')"> 비밀번호 보기
					</span><br>
					<span class="tip">* 영어 소문자와 숫자.</span> 
					</td>
				</tr>
				<tr>
					<td>비밀번호<br>확인</td>
					<td>
					<span>
					<input type="password" class="form-control" id="passwordCheck"
							name="passwordCheck" pattern="[a-z0-9]+" required 
							oninput="passwordChecked()" />
					<input type="checkbox" onclick="togglePasswordVisibility('passwordCheck')"> 비밀번호 보기
					</span><br>
					<span class="tip">* 비밀번호를 한번 더 입력하세요.</span>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" id="name"
						name="name" /></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="text" class="form-control" id="phone"
						name="phone" maxlength="13"
           				oninput="formatPhoneNumber(this)"
           				/></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
		<br> 
		<a href="loginPage.do"> 로그인 </a> &nbsp;&nbsp;&nbsp;
		<a href="indexPage.do"> 뒤로가기 </a>
	</div>
</body>
</html>