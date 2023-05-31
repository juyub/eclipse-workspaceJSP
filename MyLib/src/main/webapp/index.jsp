<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
html{
	background: url("/MyLib/image/wall.jpg");
	background-size: 100% 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
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
	margin-top:2%;
	
}

section {
	color:white;
	margin-left: 17%;
	margin-right: 17%;
	min-height: 450px;
	padding: 20px;
}

footer {
  background-color: lightgray;
  padding: 20px;
  text-align: center;
  position: fixed;
  left: 15%;
  right: 15%;
  bottom: 2%;
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