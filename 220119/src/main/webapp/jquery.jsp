<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.active {
	background-color: cyan;
}
</style>

</head>
<body>
	<ul class="klist">
		<li data-price="500" data-pub="영진">java</li>
		<li data-price="300" data-pub="영진">jsp</li>
		<li data-price="400" data-pub="영진">spring</li>
	</ul>

	<button type="button" id="btnCount">선택확인</button>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		$("li").on("click", function() { //click 대신 bind 사용가능

			//$(event.target).css("backgroundColor","yellowgreen"); // == $(this.target)

			//클래스 여부를 확인해서 있으면 지우고 없으면 만들기
			/* if ($(this).hasClass("active")) {
				$(this).removeClass("active");
			}else{
				$(this).addClass("active");
			} */

			$(this).toggleClass("active");
			
			//가격을 alert로 띄우기
			alert($(this).data("price"));

		});

		//클래스가 active인 태그 찾아서 개수 출력
		$("#btnCount").on("click", function() {
			//alert($(".active").length + "개가 선택됨");

			//선택된 내용을 콘솔에 출력
			var list = $(".active");
			
			
			for (var i = 0; i < list.length; i++) {
				//debugger//debugger 걸면 멈춤
				console.log($(list[i]).html());
			}

			for (temp of list) {
				//debugger//debugger 걸면 멈춤
				console.log($(temp).html());
			}
			
			$.each(list, function(i, item) {
				console.log($(item).html());
				
			});
			
		})
	</script>
</body>
</html>