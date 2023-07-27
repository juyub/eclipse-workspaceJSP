<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/hello/hello.do">hello</a>
	<a href="<%= request.getContextPath() %>/method/method.do">method</a>
	<a href="<%= request.getContextPath() %>/form/joinForm.do">form</a>
	<a href="<%= request.getContextPath() %>/ajax/resBody.do">문자열 응답</a>
	<a href="<%= request.getContextPath() %>/ajax/resBody.json">JSON 응답</a>
	<a href="<%= request.getContextPath() %>/ajax/resVOBody.json">JSON VO 응답</a>
	<a href="<%= request.getContextPath() %>/ajax/resStringListBody.json">JSON List(문자열) 응답</a>
	<a href="<%= request.getContextPath() %>/ajax/resVOListBody.json">JSON List(vo) 응답</a>
	<a href="<%= request.getContextPath() %>/file/uploadForm.do">파일업로드</a>
</body>
</html>