<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<style>
.l-image {
   width: 80px;
}
a {
  text-decoration: none;
  color: inherit;
}
.link-spacing {
	font-size:25px;
	margin-right: 10px; 
	margin-left: 10px; 
}
</style>

<body>

<table style="width:90%" align="center" border="1">
  <tr>
  	<td style="width: 80px;">
  	<a href="${contextPath}/index">
  	<img src="/image/user.png" class="l-image" alt="로고"></a>
  	</td>
    <td align="center">
    <a href="getBoardList" class="link-spacing">게시판</a>
    <!-- <a href="#" id="fetch-boards" class="link-spacing">타게시판</a> -->
    <a href="getBoardListRest" class="link-spacing">타게시판</a>
    </td>
  </tr>
</table>

<script>
	$("#fetch-boards").on("click", function(e) {
	  e.preventDefault();
	  fetchBoardData();
	});
	function fetchBoardData() {
	  $.ajax({
	    url: "http://172.31.9.177:8080/newsapi", // 실제 데이터를 가져올 URL 입니다
	    type: "GET",
	    dataType: "json",
	    success: function(data) {
	      // 데이터를 성공적으로 가져온 경우 sessionStorage에 저장 후 페이지 이동
	      sessionStorage.setItem("boardListData", JSON.stringify(data));
	      window.location.href = "getRestBoardList.jsp";
	    },
	    error: function(xhr, status, error) {
	      console.error("Failed to retrieve data:", status, error);
	    }
	  });
	}
	$(document).ready(function() {
	  displayBoardDataFromSession();
		// 작업 후 이 함수가 데이터를 처리하여 표시합니다.
	});
    
    /* $(document).ready(function() {
      // 클릭 이벤트 리스너 추가
      $("#fetch-boards").on("click", function(e) {
        e.preventDefault();
        fetchBoardData();
      });

      function fetchBoardData() {
        $.ajax({
          url: "http://172.31.9.177:8080/newsapi", // 실제 데이터를 가져올 URL 입니다
          type: "GET",
          dataType: "json",
          success: function(data) {
            // 데이터를 성공적으로 가져온 경우 sessionStorage에 저장 후 페이지 이동
            sessionStorage.setItem("boardListData", JSON.stringify(data));
            window.location.href = "getRestBoardList.jsp";
          },
          error: function(xhr, status, error) {
            console.error("Failed to retrieve data:", status, error);
          }
        });
      }
    }); */
  </script>

</body>
</html>