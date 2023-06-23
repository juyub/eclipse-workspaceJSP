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
			
			/* $('#searchResult').empty() */
			
			// 날짜 추출
			let searchDate = $('#searchDate').val().split('-').join('')
			console.log(searchDate)
			
			// 2023-06-21 박스오피스 요청
			// $.ajax()	
			$.ajax({
				url: 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json',
				/* type: 'get', */
				/* data: 'key=&targetDt=', */
				data:{ /* json형태로 객체를 넘김 */
					key: 'feb2dad836f17af7bf448b61f39db3b8',
					/* targetDt: '20230621', */
					targetDt: searchDate,
					itemPerPage: '5'
				},
				success: callback,   /* callback - 함수명 */ /* javascript는 파마리터를 취급하지않고 오버로딩을 지원하지 않아, 그냥 마지막꺼 실행함 */
				error: function(){
					alert('실패')
				}
			})	
		})
		
	})
	
	function callback(result){    /* 어떤 일이 완료되면 자동으로 호출 callback */
		let list = result.boxOfficeResult.dailyBoxOfficeList
		
		$('#searchResult').empty()
		
		for(let i = 0; i<list.length; i++) {
			let movieInfo = list[i]
			let name = movieInfo.movieNm
			let rank = movieInfo.rank
			let audiCnt = movieInfo.audiCnt
			
			/* console.log(rank, name, audiCnt) */
			$('#searchResult').append('<h4>' + rank + '위</h4>')
			$('#searchResult').append('<strong>' + name + '</strong> (' + audiCnt + '명)<br>')
			$('#searchResult').append('<button>상세보기</button>')
			$('#searchResult').append('<hr>')
			
		}
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





























