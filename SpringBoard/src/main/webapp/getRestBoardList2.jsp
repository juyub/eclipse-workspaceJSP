<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- <link rel="stylesheet" type="text/css" href="css/main.css"> -->

<style>
table {
	border-collapse: collapse;
}
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
$(document).ready(function() {
	  displayBoardDataFromSession();

	  function displayBoardDataFromSession() {
		  var boardData = JSON.parse(sessionStorage.getItem("boardListData"));
		  if (boardData) {
		    boardData.forEach(function (board, index) {
		      createTableRows(index, board);
		    });

		    sessionStorage.removeItem("boardListData");
		  }
		}

	  function createTableRows(index, board) {
		  var newRow = `
		        <tr>
		          <td data-seq="${board.seq}"></td>
		          <td style="width: 35%;" data-title="${board.title}" data-href="api/getBoard/${board.seq}"></td>
		          <td data-writer="${board.writer}"></td>
		          <td data-reg-date="${board.regDate}"></td>
		          <td data-delete-link>
		            <img src="/SpringBoard/image/deleteIcon.png" style="width:15px;">
		          </td>
		        </tr>`;
		  $("#board-list-table").append(newRow);
		  fillBoardTableCells(index, board);
		}

	  function fillBoardTableCells(index, board) {
	    $("td[data-seq]").eq(index).text(board.seq);
	    $("td[data-writer]").eq(index).text(board.writer);
	    $("td[data-title]").eq(index).text(board.title).wrapInner('<a href="' + $("td[data-title]").eq(index).attr('data-href') + '"></a>');
	    $("td[data-reg-date]").eq(index).text(dateFormat(board.regDate));
	  }

	  function dateFormat(dateString) {
	    var date = new Date(dateString);
	    return date.getFullYear() + "/" +
	           (date.getMonth() + 1).toString().padStart(2, '0') + "/" +
	           date.getDate().toString().padStart(2, '0') + " " +
	           date.getHours().toString().padStart(2, '0') + ":" +
	           date.getMinutes().toString().padStart(2, '0') + ":" +
	           date.getSeconds().toString().padStart(2, '0');
	  }
	});
</script>

</head>
<body>

	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	
	<section>
		<table id="board-list-table" style="width:90%" align="center" border="1">
		  <tr>
		    <th style="width: 50px;">번호</th>
		      <th>제목</th>
		      <th>글쓴이</th>
		      <th>작성일</th>
		      <th>삭제</th>
		  </tr>
		</table>		
	</section>
	
</body>
</html>
