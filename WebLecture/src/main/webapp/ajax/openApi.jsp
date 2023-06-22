<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#searchResult {
		width:70%;
		height:500px;
		border:1px solid red;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
	/* window.onload = function(){
		alert('loading...')
	} */
	/* $(식별자).함수 */
	/* $(document).ready(function(){
		alert('loading...')
	}) */
	/* $(document).ready(function(){
		$('button').click(function(){
			alert('click')					
		})
	}) */
	$(document).ready(function(){
		
		$('button').click(function(){
			// 2023-06-21 박스오피스 요청
			// $.ajax()	
			$.ajax({
				url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
				/* type: 'get', */
				/* data: 'key=&targetDt=', */
				data:{
					key: 'feb2dad836f17af7bf448b61f39db3b8',
					targetDt: '20230621',
					itemPerPage: '5'
				},
				success: callback, 
				error: function(){
					alert('실패')
				}
			})	
		})
		
	})
	
	let list
	function callback(result){
		list = result.boxOfficeResult.dailyBoxOfficeList
		console.log(list)		
	}
</script>
</head>
<body>
	<h2>일별 박스오피스 서비스</h2>
	검색일 : <input type="date" id="searchDate"><button>검색</button>
	<h3>검색결과</h3>
	<div id="searchResult"></div>
</body>
</html>





























