<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화 API 테스트</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/movie.js"></script>
<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl7/1LP49MileyJ9fVmp7T/IGwfsIcymce6C1EPcWl"
	crossorigin="anonymous">
<!-- 부트스트랩 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz4fnFO9gybB5l5D/7WmEfi8di6G8jPlb7GfFYo3bYv4XC8eFlWJxc7hFP"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
	integrity="sha384-BQoub7yA1x7da6P4tvYvq1LPXtMfWEoc3ujeF8tnF8K_lnJN5z7suIaBn5xEg5JU"
	crossorigin="anonymous"></script>
</head>
<body onload="moviePost()">
	<h1>예정된 영화 목록</h1>
	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators"></div>
		<div class="carousel-inner"></div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
</body>
</html>