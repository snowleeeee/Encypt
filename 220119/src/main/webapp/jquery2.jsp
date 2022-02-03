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
		<li data-price="500">java
			<button type="button" class="btnPrice">가격확인</button>
	</ul>
	<button type="button" id="btnAdd">추가</button>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
		
	<script>
		let datas = [ {
			name : 'javascript',
			price : 1000
		}, {
			name : 'html',
			price : 2000
		}, {
			name : 'css',
			price : 3000
		} ]
		
		$("#btnAdd").on("click", function() {
			for(data of datas){
				
				var btn = $("<button>").attr("type","button").addClass("btnPrice").html("가격확인");
				
				//html() data() append()
				var li = $("<li>").data("price", data.price).html(data.name)//
								  .append(btn);
				
				$(".klist").append(li);
				//동적으로 추가된 태그는 따로 걸어야함
				
			}
		});
		
		//그룹 이벤트 : 동적으로 추가된 태그에 대해서 이벤트를 지정하려면 부모에 이벤트를 지정해야함
		$(".klist").on("click", "li", function () {//두번째 인수가 있으면 그룹이벤트 없으면 그냥 이벤트
			
			event.stopPropagation(); // 전파중지
			$(this).toggleClass("active");
			
		})
		
		//버튼에 클릭이벤트 걸기
		$(".klist").on("click", ".btnPrice", function () {//두번째 인수가 있으면 그룹이벤트 없으면 그냥 이벤트
			
			event.stopPropagation(); // 전파중지

			
			//가격을 alert
			var price = $(".btnPrice").closest("li").data("price") //.closest() : 조상 // .parent() : 부모
			// == $(".btnPrice").parent().data("price")
			alert(price);
		})
		
		
		
	</script>
</body>
</html>