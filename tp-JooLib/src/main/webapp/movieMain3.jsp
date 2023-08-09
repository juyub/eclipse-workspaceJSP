<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>영화</title>
<script src="https://code.jquery.com/jquery-3.6.4.js"
	integrity="sha256-a9jBBRygX1Bh5lt8GZjXDzyOB+bWve9EiO7tROUtj/E="
	crossorigin="anonymous"></script>
<!-- 부트스트랩 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous" />
<!-- 부트스트랩 JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
div {
	display: flex;
	flex-wrap: wrap;
}

article {
	border: 1px solid black;
	margin: 10px;
	padding: 10px;
	cursor: pointer;
	width: 300px;
}

.carousel-item img {
	object-fit: contain;
	width: 70%;
	/* max-width: 100%; */
	height: 100%;
	margin: 0 auto;
}

.carousel-inner {
	max-height: 600px;
}

.carousel-item {
	height: 600px;
}

.carousel-caption {
	bottom: 40%;
}

.carousel-control-prev-icon, .carousel-control-next-icon {
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 50%;
	padding: 10px;
}
body {
  margin-left: 10%;
  margin-right: 10%;
}
</style>
<script>
    function nextPage(id) {
        window.location.href = "movieDetail.do?id=" + id;
    }

    function moviePost() {
        $.ajax({
            url: 'https://api.themoviedb.org/3/movie/upcoming',
            data: {
                api_key: 'a64533e7ece6c72731da47c9c8bc691f',
                language: 'ko-KR',
                page: 1
            },
            success: function (data) {
                const { results } = data;

                for (let i = 0; i < results.length; i++) {
                    const post = results[i];

                    if (i === 0) {
                        $(".carousel-indicators").append(
                            '<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="' + i + '" class="active"></button>'
                        );
                        $(".carousel-inner").append(
                            '<div class="carousel-item active">' +
                                '<img src="https://image.tmdb.org/t/p/w500' + post.poster_path + '" class="d-block w-100" alt="' + post.title + '" onclick="nextPage(' + post.id + ')">' +
                                '<div class="carousel-caption d-none d-md-block">' +
                                    '<h5>' + post.title + '</h5>' +
                                    '<p>' + post.release_date + '</p>' +
                                '</div>' +
                            '</div>'
                        );
                    } else {
                        $(".carousel-indicators").append(
                            '<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="' + i + '"></button>'
                        );
                        $(".carousel-inner").append(
                            '<div class="carousel-item">' +
                                '<img src="https://image.tmdb.org/t/p/w500' + post.poster_path + '" class="d-block w-100" alt="' + post.title + '" onclick="nextPage(' + post.id + ')">' +
                                '<div class="carousel-caption d-none d-md-block">' +
                                    '<h5>' + post.title + '</h5>' +
                                    '<p>' + post.release_date + '</p>' +
                                '</div>' +
                            '</div>'
                        );
                    }

                    if (i % 4 === 0) {
                        $("#container2").append(`<div class="row">`);
                    }
                    $("#container2 .row:last-child").append(`
                            <div class="col-md-3">
                                <div class="card mb-3" onclick="nextPage(` + post.id + `)">
                                    <img src="https://image.tmdb.org/t/p/w500` + post.poster_path + `" class="card-img-top" alt="` + post.title + `">
                                    <div class="card-body">
                                        <h5 class="card-title">` + post.title + `</h5>
                                        <p class="card-text">` + post.release_date + `</p>
                                    </div>
                                </div>
                            </div>
                        `);
                    if (i % 4 === 3 || i === results.length - 1) {
                        $("#container2").append(`</div>`);
                    }
                }
            },
            error: function (err) {
                console.error('영화 데이터를 가져오는 데 실패했습니다.', err);
            }
        });
    }
</script>

</head>

<body onload="moviePost()">
	<header>
		<jsp:include page="/topMenu.jsp" />
	</header>
	
	
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

	<div id="container2" class="container"></div>
</body>
</html>