<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>네이버 뉴스 검색 프록시 예제</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // 검색어와 필요한 기타 정보 설정
            var query = "주식"; // 검색어
            var display = 10; // 검색 결과 개수
            var start = 1; // 검색 시작 위치

            // 서블릿을 통한 API 요청
            $.ajax({
            	url: "proxy", // 요청 URL 변경
                method: "GET",
                dataType: "json",
                data: {
                    query: query,
                    display: display,
                    start: start
                },
                success: function(response) {
                	var results = response.items;
                    var $newsContainer = $("#news-container");
                    // var output = [];
                    
                    results.forEach(function(item) {
                        var newsItem = {
                            "title": item.title,
                            "originallink": item.originallink,
                            "link": item.link,
                            "description": item.description,
                            "pubDate": item.pubDate
                        };
                        
                     // Generate HTML for the news item
                        var newsHtml = '<div class="news-item">' +
                            '<h3><a href="' + newsItem.link + '" target="_blank">' + newsItem.title + '</a></h3>' +
                            '<p>' + newsItem.description + '</p>' +
                            '<p><a href="' + newsItem.originallink + '" target="_blank">원문 링크</a></p>' +
                            '<p>게시일: ' + newsItem.pubDate + '</p>' +
                            '</div>';

                        // Append the generated HTML to the news container
                        $newsContainer.append(newsHtml);
                        
                        // output.push(newsItem);
                    });

                    // console.log(output);
                },
                error: function(xhr, status, errorThrown) {
                    console.log("Error: " + errorThrown);
                }
            });
        });
    </script>
    <style>
        .news-item {
            border: 1px solid black; /* 테두리 추가 */
            width: 60%; /* 너비를 80%로 설정 */
            margin: 10px auto; /* 상하 여백 10px, 좌우 여백을 자동으로 설정하여 중앙 정렬 */
        }
    </style>
</head>
<body>
	<div id="news-container"></div>
</body>
</html>
