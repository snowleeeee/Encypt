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
	<h3>�ڽ����ǽ�</h3>
	
	<div id="result"></div>
	<div id="info"></div>
	<script type="text/javascript">
		function movieList(){
			var url ="http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";
			$.ajax({
				url : url,
				
			}).done( function(datas){
				var nm = '';
				var list = datas.boxOfficeResult.dailyBoxOfficeList;
				for(var i=0;i<list.length;i++){
					var infoUrl =
					$("#result").append(`<a href="javascript:movieInfo('\${list[i].movieCd}');"> \${i+1}  �� :  \${list[i].movieNm} </a><br>`);
					
				}
			
				// ��ȭ Ŭ���ϸ� ��ȭ �ڵ带 movieInfo�� �Ѱܼ� �ؿ� ����
				
			} );
		}
		
		movieList();
		
		function movieInfo(cd){
			
			var urlInfo = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=" + cd;
			$.ajax({
				url : urlInfo,
				
			}).done( function(datas){
				
				$("#info").empty();
				
				var nm = '';
				
				//var list = datas.movieInfoResult.movieInfo.directors.director.peopleNm;
				var actorList = datas.movieInfoResult.movieInfo.actors;
				for(var i = 0; i<actorList.length; i++){
					$("#info").append(actorList[i].peopleNm + "<br>");
				}
				var director = datas.movieInfoResult.movieInfo.directors;
				$("#info").append("<br>������ : "+director[0].peopleNm);
				
				
			} );
		}
		
	
	</script>
</body>
</html>