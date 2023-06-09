<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="../css/user.css"> -->
<style>
/* html{
	background: url("/JooBankT/image/backWall.jpg");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
} */
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function execDaumPostcode() {
		new daum.Postcode( {
			oncomplete: function( data ) {
				document.getElementById( 'zip-code' ).value = data.zonecode;
				document.getElementById( 'address-1' ).value = data.address;
				document.getElementById( 'address-1-1' ).value = data.jibunAddress;
				document.getElementById( 'address-2' ).focus();
			}
		} ).open();
	}
	function execDaumPostcodeReset() {
		document.getElementById( 'zip-code' ).value = null;
		document.getElementById( 'address-1' ).value = null;
		document.getElementById( 'address-1-1' ).value = null;
		document.getElementById( 'address-2' ).value = null;
	}
</script>
</head>
<body>
	<div >
		<h1>회원가입</h1>
		<form action="${ pageContext.request.contextPath }/join.do" method="post" name="joinForm"
			onsubmit="return checkForm()">
			<table id="join-table" border="1">
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" class="form-control" id="id" name="id"
						pattern="[a-z0-9]+" />
						<input type="button" value="ID중복확인" class="btc"
						onClick="idCheck(this.form.id.value)">
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					<input type="password" class="form-control" id="password"
						name="password" pattern="[a-z0-9]+" required />
					</td>
				</tr>
				<tr>
					<td>비밀번호<br>확인</td>
					<td>
					<input type="password" class="form-control" id="passwordCheck"
							name="passwordCheck" pattern="[a-z0-9]+" required 
							oninput="passwordChecked()" />
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
				<tr>
					<td>이메일</td>
					<td><input type="text" class="form-control" id="mail" name="mail"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
					<input type="text" id="zip-code" placeholder="우편번호" readonly>
					<input type="button" onclick="execDaumPostcode()" value="우편번호">
					<input type="button" onclick="execDaumPostcodeReset()" value="초기화">
					<br>
					<input type="text" id="address-1" placeholder="도로명주소" style="width: 300px" readonly> <br>
					<input type="text" id="address-1-1" placeholder="지번주소" style="width: 300px" readonly> <br>
					<input type="text" id="address-2" placeholder="상세주소" style="width: 300px">
					</td>
				</tr>
			</table>
			<br>
			<button type="submit" class="btn btn-primary">회원가입</button>
		</form>
		<br> 
		<a href="loginPage.do"> 로그인 </a> &nbsp;&nbsp;&nbsp;
		<a href="indexPage.do"> 뒤로가기 </a>
	</div>
</body>
</html>