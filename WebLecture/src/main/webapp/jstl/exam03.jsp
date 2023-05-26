<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String[] names = {"강길동","홍길동","윤길동","박길동","김길동"};
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("length", names.length);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%-- 마지막 출력값위엔 ","가 찍히지 않도록 만들어 보기 --%>
	<c:forEach items="${ names }" var="name">
		${ name },
	</c:forEach> <br>
	<br>
	
	<c:forEach begin="0" end="${ fn:length(names) }" var="i">
		${ names[i] } &nbsp;&nbsp;
	</c:forEach> <br>
	<br>

	<c:forEach begin="0" end="${ length }" var="i">
		${ names[i] } &nbsp;&nbsp;
	</c:forEach> <br>
	<br>
	
	
	년도선택 :
	<select>
		<c:forEach begin="1960" end="2023" var="year">
			<option> ${ year } </option>
		</c:forEach>
	</select> <br>
	<br>
		
	<c:forEach begin="1" end="10" var="i">
		${ i } &nbsp;&nbsp;
	</c:forEach>
	<br>

</body>
</html>