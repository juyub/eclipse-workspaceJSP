<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<head>
<meta charset="UTF-8">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
  function backToList(obj){
	 obj.action="${contextPath}/boardList.do";
	 obj.submit();
  }
</script> 
<title>답글쓰기 페이지</title>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/main.css"> --%>
<style type="text/css">
td {
    padding: 5px;
}

a {
    text-decoration: none;
    color: inherit;
}

section {
    margin-left: 5%;
    margin-right: 5%;
    padding: 20px;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
	 <h1>답글쓰기</h1>
	  <form name="frmReply" method="post"  action="${contextPath}/addReply" >
	  <input type="hidden" name="seq" value="${param.seq}" />
	    <table>
			<tr>
				<td>글제목</td>
				<td><input type="text" size="58"  maxlength="100" name="title" /></td>
			</tr>
	    	<tr>
				<td >글쓴이</td>
				<td><input type="text" size="5"name="writer"/> </td>
			</tr>
			<tr>
				<td valign="top"><br>글내용</td>
				<td><textarea name="content" rows="10" cols="60" maxlength="4000"> </textarea> </td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type=submit value="답글반영하기" />
					<input type=button value="취소"onClick="backToList(this.form)" />
				</td>
			</tr>
	    </table>
	  </form>
	</section>
</body>
</html>