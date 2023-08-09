<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
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
#tr_btn_modify {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function backToList(obj) {
    obj.action = "getBoardList";
    obj.submit();
}

function fn_enable() {
    document.getElementById("i_title").disabled = false;
    document.getElementById("i_content").disabled = false;

    document.getElementById("tr_btn_modify").style.display = "block";
    document.getElementById("tr_btn").style.display = "none";
}

function fn_modify_board(obj) {
    obj.action = "updateBoard";
    obj.submit();
}

function fn_remove_board(url, seq) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    var seqInput = document.createElement("input");
    seqInput.setAttribute("type", "hidden");
    seqInput.setAttribute("name", "seq");
    seqInput.setAttribute("value", seq);

    form.appendChild(seqInput);
    document.body.appendChild(form);
    form.submit();
}

function fn_reply_form(url, seq) {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    var seqInput = document.createElement("input");
    seqInput.setAttribute("type", "hidden");
    seqInput.setAttribute("name", "seq");
    seqInput.setAttribute("value", seq);

    form.appendChild(seqInput);
    document.body.appendChild(form);
    form.submit();
}
</script>
</head>
<body>
    <header>
        <jsp:include page="/topMenu.jsp" />
    </header>
    
    <section>
        <br>
        <button><a href="javascript:history.back()">뒤로가기</a></button>
        <input type=button value="답글쓰기" onClick="fn_reply_form('${contextPath}/board/replyBoard.jsp', ${board.seq})">
        <br><br>
        <form action="${contextPath}/updateBoard" method="post">
            <input type="hidden" name="seq" value="${board.seq}">
            <table border="1">
                <tr>
                    <th>제목</th>
                    <td>
                        <input id="i_title" name="title" type="text" value="${board.title}" disabled>
                    </td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${board.writer}</td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td>
                        <textarea id="i_content" name="content" cols="40" rows="10" disabled>${board.content}</textarea>
                    </td>
                </tr>
                <tr>
                    <th>작성일자</th>
                    <td>
                        <fmt:formatDate value="${board.regDate}" pattern="yy/MM/dd HH:mm:ss"/>
                    </td>
                </tr>
            </table>
            <br>
            <table>
                <tr id="tr_btn">
                    <td>
                         <input type="button" value="수정하기" onClick="fn_enable()">
                         <input type="button" value="삭제하기" onClick="fn_remove_board('deleteBoard', ${board.seq})">
                    </td>
                </tr>
                <tr id="tr_btn_modify">
                    <td>
                        <input type="button" value="수정반영하기" onClick="fn_modify_board(this.form)">
                        <input type="button" value="취소" onClick="backToList(this.form)">
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <!-- 댓글 목록 -->
		<table border="0" width="80%">
		  <tr>
		    <td colspan="3">
		      <strong>[ 댓글 목록 ]</strong>
		    </td>
		  </tr>
		  <c:forEach var="comment" items="${commentList}">
		 	 <form action="${contextPath}/updateComment" method="post">
			    <tr>
			        <td>${comment.writer} : <input type="text" name = "content" value="${comment.content}"></td>
			        <td><fmt:formatDate value="${comment.regtime}" pattern="yy/MM/dd HH:mm:ss"/></td>
			        <td>
		                <input type="hidden" name="commentNO" value="${comment.commentNO}"/>
		                <input type="hidden" name="seq" value="${board.seq}"/>
		                <button type="submit">수정</button>
		                <button><a href="deleteComment?commentNO=${ comment.commentNO }&seq=${board.seq}">삭제</a></button>
			        </td>
			 	</tr>
			 </form>
			</c:forEach>
		</table>
		
		<hr>
	
		<!-- 댓글 입력 폼 -->
		<form name="frmComment" method="post" action="${contextPath}/addComment">
		  <table border="1" width="80%">
		    <tr>
		      <input type="hidden" name="seq" value="${board.seq}" />
		      <%-- <input type="hidden" name="id" value="${login.userid}" /> --%>
		      <td>
		      작성자 : <input type="text" name="writer"  /> <br>
		      <input type="text" name="content" style="width: 70%" />
		      <input type="submit" value="덧글 작성" />
		      </td>
		    </tr>
		  </table>
		</form>
    </section>
</body>
</html>
