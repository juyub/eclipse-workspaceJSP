<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#tr_btn_modify {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
      function backToList(obj){
	    obj.action="${contextPath}/boardList.do";
	    obj.submit();
	  }
   	 function fn_enable(obj){
   		 document.getElementById("i_title").disabled=false;
   		 document.getElementById("i_content").disabled=false;
   		 
   		 document.getElementById("tr_btn_modify").style.display="block";
   		 document.getElementById("tr_btn").style.display="none";
   	 }
   	 
   	 function fn_modify_board(obj){
   		 obj.action="${contextPath}/updateBoard.do";
   		 obj.submit();
   	 }
   	 
   	function fn_remove_board(url, boardNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var boardNOInput = document.createElement("input");
	     boardNOInput.setAttribute("type","hidden");
	     boardNOInput.setAttribute("name","boardNO");
	     boardNOInput.setAttribute("value", boardNO);
		 
	     form.appendChild(boardNOInput);
	     document.body.appendChild(form);
	     form.submit();
	 }
   	function fn_reply_form(url, boardNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var boardNOInput = document.createElement("input");
	     boardNOInput.setAttribute("type","hidden");
	     boardNOInput.setAttribute("name","boardNO");
	     boardNOInput.setAttribute("value", boardNO);
		 
	     form.appendChild(boardNOInput);
	     document.body.appendChild(form);
		 form.submit();
	 }
</script>
<link rel="stylesheet" type="text/css"
	href="${contextPath}/css/main.css">
</head>
<body>
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	<section>
		<form name="frmBoard" method="post">
			<table border="0" align="center">
				<tr>
					<td width="150" align="center" bgcolor="#FF9933">글번호</td>
					<td><input type="text" value="${board.boardNO }" disabled />
						<input type="hidden" name="boardNO" value="${board.boardNO}" />
					</td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#FF9933">작성자 아이디</td>
					<td><input type="text" value="${board.memberID }" name="id"
						disabled /></td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#FF9933">제목</td>
					<td><input type="text" value="${board.title }" name="title"
						id="i_title" disabled /></td>
				</tr>
				<tr>
					<td width="150" align="center" bgcolor="#FF9933">내용</td>
					<td><textarea rows="10" cols="60" name="content"
							id="i_content" disabled />${board.content }</textarea></td>
				</tr>
				<tr>
					<td width="20%" align="center" bgcolor="#FF9933">등록일자</td>
					<td><input type=text
						value="<fmt:formatDate value="${board.regdate}" />" disabled /></td>
				</tr>
				<tr id="tr_btn_modify"  >
				   <td colspan="2" align="center" >
				       <input type=button value="수정반영하기" onClick="fn_modify_board(frmBoard)"  >
			         <input type=button value="취소"  onClick="backToList(frmBoard)">
				   </td>   
  				</tr>

				<tr id="tr_btn">
					<td colspan=2 align="center">
						<c:if test="${ login.memberNO == board.memberNO }">
							<input type=button value="수정하기" onClick="fn_enable(this.form)">
							<input type=button value="삭제하기"
								onClick="fn_remove_board('${contextPath}/deleteBoard.do', ${board.boardNO})">
						</c:if> 
						
						<input type=button value="리스트로 돌아가기"	onClick="backToList(this.form)">
						<input type=button value="답글쓰기" onClick="fn_reply_form('${contextPath}/board/replyBoard.jsp', ${board.boardNO})">
					</td>
				</tr>
			</table>
		</form>
		
		<br>
		<hr>
		<!-- 댓글 목록 -->
		<table border="0" align="center" width="80%">
		  <tr>
		    <td colspan="3">
		      <strong>[ 댓글 목록 ]</strong>
		    </td>
		  </tr>
		  <c:forEach var="comment" items="${commentList}">
		 	 <form action="${contextPath}/updateComment.do" method="post">
			    <tr>
			        <td>${comment.memberID} : <input type="text" name = "content" value="${comment.content}"></td>
			        <td><fmt:formatDate value="${comment.regdate}" pattern="yy/MM/dd"/></td>
			        <td>
			        <c:if test="${comment.memberID == login.memberID}">
		                <input type="hidden" name="commentNO" value="${comment.commentNO}"/>
		                <button type="submit">수정</button>
		                <button><a href="deleteComment.do?commentNO=${ comment.commentNO }">삭제</a></button>
		                </form>
	                 </c:if>
			        </td>
			 	</tr>
			 </form>
			</c:forEach>
		 <%--  <c:forEach var="comment" items="${commentList}">
		    <tr>
		      <td>${comment.memberID}: ${comment.content}</td>
		      <td>작성일: <fmt:formatDate value="${comment.regdate}" pattern="yyyy/MM/dd"/></td>
		    </tr>
		  </c:forEach> --%>
		</table>
		
		<br>
		<hr>
		<!-- 댓글 입력 폼 -->
		<form name="frmComment" method="post" action="${contextPath}/addComment.do">
		  <table border="0" align="center" width="60%">
		    <tr>
		      <input type="hidden" name="boardNO" value="${board.boardNO}" />
		      <input type="hidden" name="memberNO" value="${login.memberNO}" />
		      <td><input type="text" name="content" style="width: 100%" /></td>
		      <td></td>
		      <td><input type="submit" value="덧글 작성" /></td>
		    </tr> 
		  </table>
		</form>
		
	</section>
</body>
</html>