<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#section {
		
	}
</style>
<script src="http://code.jquery.com/jquery-3.7.0.min.js"></script>
<script>

	// 댓글리스트 조회(게시판번호)
	let getReplyList = function() {
		$.ajax({
			url: '${pageContext.request.contextPath}/reply/${board.no}',
			type: 'get',
			success: function(result) {
				let list = JSON.parse(result)
				
				$('#replyList').empty()
				
				$(list).each(function() {
					//console.log(this)
					
					let str = ''
					str += '<hr>'
					str += '<div>'
					str += '<strong>' + this.content + '</strong>'
					str += '(' + this.writer + ')'
					str += '&nbsp;&nbsp; ' + this.regDate + '&nbsp;&nbsp; '
					str += '<button id=' + this.no + '>삭제</button>'
					str += '</div>'
					
					$('#replyList').append(str)
				})
				
			}, error: function() {
				alert('실패')
			}
		})
	}
	
	$(document).ready(function() {
		getReplyList()
	})

	$(document).ready(function() {
		$('#replyAddBtn').click(function() {
			let content = document.rform.content.value
			let writer = document.rform.writer.value
			
			// http://localhost:8080/Mission-Spring/reply
			//				?content=어머어머&writer=hong&boardNo=42
			$.ajax({
				url: '${pageContext.request.contextPath}/reply',
				type: 'post',
				data: {
					content: content,
					writer: writer,
					boardNo: ${board.no}
				}, success: function() {
					document.rform.content.value = ''
						document.rform.writer.value = ''
					getReplyList()
				}, error: function() {
					alert('실패')
				}
			})
		})
	})
</script>
</head>
<body>
	<div id="section" align="center">
	<h2>게시판 상세 페이지</h2>
	
	<table border="1" style="width: 80%">
		<tr>
			<th width="25%">번호</th>
			<td>${ board.no }</td>
		</tr>
		<tr>
			<th width="25%">제목</th>
			<td>${ board.title }</td>
		</tr>
		<tr>
			<th width="25%">글쓴이</th>
			<td>${ board.writer }</td>
		</tr>
		<tr>
			<th width="25%">내용</th>
			<td>${ board.content }</td>
		</tr>
		<tr>
			<th width="25%">조회수</th>
			<td>${ board.viewCnt }</td>
		</tr>
		<tr>
			<th width="25%">등록일</th>
			<td>${ board.regDate }</td>
		</tr>
	</table>
	<button onclick="location.href='${pageContext.request.contextPath}/board'">목 록</button>
	<button onclick="location.href=''">수 정</button>
	<button onclick="location.href=''">삭 제</button>
	
	<br>
	<br>
	<hr>
	<%-- 댓글관련 --%>
	
	<form name="rform">
		댓글 : <input type="text" name="content" size="50" />
		이름 : <input type="text" name="writer" size="10" />
		<button type="button" id="replyAddBtn">댓글추가</button>
		<div id="replyList">
		</div>
	</form>
	
	</div>
</body>
</html>













