<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>News API</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }
    th, td {
      border: 1px solid #aaa;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
  <h1>News API</h1>
  <table id="newsTable">
    <thead>
      <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Content</th>
        <th>Author</th>
        <th>Published Date</th>
      </tr>
    </thead>
    <tbody>
      <!-- Table rows will be populated by JavaScript -->
    </tbody>
  </table>

  <script>
    $(document).ready(function() {
      fetchNews();

      function fetchNews() {
        $.ajax({
          url: "http://172.31.9.168:8080/api/news",
          type: "GET",
          dataType: "json",
          success: function(data) {
            populateTable(data);
          },
          error: function(xhr, status, error) {
            console.error("Failed to retrieve news data:", status, error);
          }
        });
      }

      function populateTable(newsData) {
        var tableBody = $("#newsTable tbody");
        newsData.forEach(function(newsItem) {
          var row = `
            <tr>
              <td>${newsItem.id}</td>
              <td>${newsItem.title}</td>
              <td>${newsItem.content}</td>
              <td>${newsItem.author}</td>
              <td>${newsItem.publishedDate}</td>
            </tr>
          `;
          tableBody.append(row);
        });
      }
    });
  </script>
</body>
</html>

