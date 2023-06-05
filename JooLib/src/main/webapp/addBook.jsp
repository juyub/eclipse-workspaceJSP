<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<h1>도서 등록</h1>
		<form action="addBook.do" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input type="text" name="author" /></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input type="text" name="publisher" /></td>
				</tr>
				<tr>
					<td>출판년도</td>
					<td><input type="text" name="publicationyear" /></td>
				</tr>
				<tr>
					<td>isbn</td>
					<td><input type="text" name="isbn" /></td>
				</tr>
				<tr>
					<td>장르</td>
					<td><input type="text" name="category" /></td>
				</tr>
				<tr>
					<td>보유권수</td>
					<td><input type="text" name="totaln" /></td>
				</tr>
				<tr>
					<td>대출가능권수</td>
					<td><input type="text" name="availablen" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="등록" /></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>