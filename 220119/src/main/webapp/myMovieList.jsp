<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>myMovieList</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  crossorigin="anonymous"></script>
</head>
<body>
	<div id="movieList"></div>
	<script type="text/javascript">
		$.ajax({
			url : 'movieList'
		}).done(function (datas) {
			$("#movieList").append(JSON.stringify(datas));
		})
	</script>
</body>
</html>