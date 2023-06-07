<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script>
	function checkForm() {
		let borrowForm = document.forms[0];
		let availablen = parseInt("${book.availablen}");
		let borrown = parseInt("${user.borrown}");
		let userno1 = parseInt("${user.userno}");
		let userno2 = parseInt("${borrow.userno}");
		
		if (availablen <= 0) {
			alert('대여가능도서가 없습니다.');
			return false;
		}
		if (borrown <= 0) {
			alert('대출가능권수를 초과하였습니다.');
			return false;
		}
		if (userno1 == userno2) {
		      alert('이미 대출하신 도서입니다');
		      return false;
		}

		return true;
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="./topMenu.jsp" />
	</header>
	
	<section>
	
	<form action="updateBook.do" method="post"> 
    <input name="bookno" type="hidden" value="${ book.bookno }"> 
    <table border="1"> 
        <tr> 
            <th>제목</th> 
            <td><input type="" name="title" value="${book.title}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr> 
            <th>작성자</th> 
            <td><input type="text" name="author" value="${book.author}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr> 
            <th>출판사</th> 
            <td><input type="text" name="publisher" value="${book.publisher}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr> 
            <th>출판연도</th> 
            <td><input type="text" name="publicationyear" value="${book.publicationyear}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr> 
            <th>ISBN</th> 
            <td><input type="text" name="isbn" value="${book.isbn}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr> 
            <th>장르</th> 
            <td><input type="text" name="category" value="${book.category}" ${user.role == 'admin' ? '' : 'readonly'} /></td> 
        </tr>
        <tr>
            <th>보유권수</th>
            <td><input type="text" name="totaln" value="${book.totaln}" ${user.role == 'admin' ? '' : 'readonly'} /></td>
        </tr>
        <tr>
            <th>대여능권수</th>
            <td><input type="text" name="availablen" value="${book.availablen}" ${user.role == 'admin' ? '' : 'readonly'} /></td>
        </tr>
        <c:if test="${ user.role == 'admin' }">
            <tr>
                <td colspan="2">
                    <input type="submit" value="수정" />
                    <button><a href="deleteBook.do?bookno=${ book.bookno }">삭제</a></button>
                </td>
            </tr>
        </c:if>
    </table>
</form>
	<c:if test="${ user.role == 'user' }">
    <form action="borrowBook.do" method="post" onsubmit="return checkForm()">
        <input name="bookno" type="hidden" value="${ book.bookno }">
        <input name="userno" type="hidden" value="${ user.userno }"> 
        <input name="userno" type="hidden" value="${ user.borrown }"> 
        <button type="submit">대출</button>
    </form>
	</c:if>
		<!-- <a href="getBookList.do">list</a> -->
		<!-- <button><a href="borrowBook.do">대출</a></button> -->
		<button><a href="getBookList.do">뒤로가기</a></button>
	</section>
	
</body>
</html>
