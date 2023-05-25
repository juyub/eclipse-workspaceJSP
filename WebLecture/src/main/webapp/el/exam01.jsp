<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--
	<%
		String msg = "hello";
	%>
	Hello!! <br>
	<%= msg %> <br>
	--%> 
	
	<%--
	
	http://localhost:8080/WebLecture/el/exam01.jsp?name=hong&id=kkk 입력시 hong
	
	--%>

	이름 : <%= request.getParameter("name") %> <br>	<%-- parameter가 없으면 null --%>
	이름 : ${ param.name } <br>	<%-- parameter가 없으면 empty --%>
	ID : ${ param.id } <br>


</body>
</html>