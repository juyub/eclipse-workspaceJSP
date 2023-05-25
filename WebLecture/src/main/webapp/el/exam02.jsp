<%@page import="book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	BookVO b = new BookVO();
	b.setIsbn("123-456");
	b.setTitle("EL이란 무엇인가?");
	b.setWriter("홍길동");

	// 공유역역(pageContext)에 "book"이란 이름으로 생성된 BookVO객체를 등록
	pageContext.setAttribute("book", b);
	
	// "book" 객체 조회
	BookVO book = (BookVO)pageContext.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	ISBN : <%= ((BookVO)pageContext.getAttribute("book")).getIsbn() %> <br>
	ISBN : <%= book.getIsbn() %> <br>
	EL ISBN : ${ book.isbn } <br>
	EL TITLE : ${ book.title } <br>
	<%-- EL COMPANY : ${ book.company } <br> --%>
	EL TITLE : ${ book['title'] } <br>	<%-- 자바빈즈나 맵에선 잘 안씀 --%> 
	
</body>
</html>