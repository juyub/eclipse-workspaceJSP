<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html{
	background: url("/JooLib/image/wall.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

body {
	margin: 0 ;
	padding: 0;
	font-family: verdana, sans-serif;
	font-size: 15px;
}

header {
	background-color: lightgray;
	margin-left: 15%;
	margin-right: 15%;
	margin-top:1%;
	
}

section {
	color:white;
	margin-left: 17%;
	margin-right: 17%;
	min-height: 450px;
	padding: 20px;
}

footer {
	margin-left: 15%;
	margin-right: 15%;
	background-color: lightgray;
	padding: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
	메인페이지입니다
	</section>
	<footer>
		<%@ include file="/jsp/include/bottom.jsp" %>
	</footer>
</body>
</html>