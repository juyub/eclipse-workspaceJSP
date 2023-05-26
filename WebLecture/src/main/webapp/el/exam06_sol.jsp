
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="book.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 1. 자바빈즈클래스 + 배열
	BookVO book = new BookVO();
	book.setTitle("성공");
	
	BookVO[] books = {book};
	
	pageContext.setAttribute("books", books);
	
	// 2. Map 객체 + 배열 - 많이 쓰임
	Map<String, String> book2 = new HashMap<>();
	book2.put("title", "성공");
	
	Map[] books2 = {book2};
	
	pageContext.setAttribute("books2", books2);
	
	// 3. 자바빈즈클래스 + 콜렉션 - 가장 많이 쓰임
	BookVO book3 = new BookVO();
	book3.setTitle("성공");
	
	List<BookVO> books3 = new ArrayList<>();
	books3.add(book3);
	
	pageContext.setAttribute("books3", books3);
	
	// 4. Map 객체 + 컬렉션
 	Map<String, String> book4 = new HashMap<>();
	book4.put("title","성공");
	
	List<Map<String, String>> books4 = new ArrayList<>();
	books4.add(book4);
	
	pageContext.setAttribute("books4", books4);
	
	
	// 다른 여러 종의 데이터를 Map으로 하나로 묶어서 가져올 수 있음
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%-- 성공 출력 4가지 방식 --%>
	성공??실패?? ${ books[0].title } <br>
	
	성공??실패?? ${ books2[0].title } <br>

	성공??실패?? ${ books3[0].title } <br>

	성공??실패?? ${ books4[0].title } <br>

</body>
</html>