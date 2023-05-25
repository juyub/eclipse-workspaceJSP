<%@page import="book.BookVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    List<Map<String, String>> books = new ArrayList<>();
    
	Map<String, String> book = new HashMap<>();
    book.put("title", "성공");
    books.add(book);
    
    pageContext.setAttribute("books", books);
%>

<%
    BookVO book2 = new BookVO();
    book2.setTitle("성공");

    List<BookVO> books2 = new ArrayList<>();
    books2.add(book2);

    pageContext.setAttribute("books2", books2);
%>

<%
	Map<String,String>[] books3 = new HashMap[1];
	Map<String, String> book3 = new HashMap<String, String>();
	book3.put("title", "성공");
	books3[0] = book3;
		
	pageContext.setAttribute("books3", books3);
%>

<%
	BookVO[] books4 = new BookVO[1];
	BookVO book4 = new BookVO();
	book4.setTitle("성공");
	books4[0] = book4;

	pageContext.setAttribute("books4", books4);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%-- 성공 출력 4가지 방식 --%>
	${ books[0].title } <br>
	
	${ books2[0].title } <br>

	${ books3[0].title } <br>

	${ books4[0].title } <br>

</body>
</html>