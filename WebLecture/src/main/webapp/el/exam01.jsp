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
	
	http://localhost:8080/WebLecture/el/exam01.jsp?name=hong&id=kkk �Է½� hong
	
	--%>

	�̸� : <%= request.getParameter("name") %> <br>	<%-- parameter�� ������ null --%>
	�̸� : ${ param.name } <br>	<%-- parameter�� ������ empty --%>
	ID : ${ param.id } <br>


</body>
</html>