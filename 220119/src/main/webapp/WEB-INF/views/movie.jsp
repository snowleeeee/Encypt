<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  crossorigin="anonymous"></script>
</head>
<body>
	<h3>박스오피스</h3>
	<div id="result"></div>
	<script type="text/javascript">
	
		var url ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";
		$.ajax({
			url : url
			
		}).done( function(datas){
			$("#restul").html(datas);
			
		} );
	
	</script>
</body>
</html>