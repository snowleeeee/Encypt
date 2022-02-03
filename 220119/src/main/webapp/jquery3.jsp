<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<input name="kor"> <input name="eng">
	<button id="btnAdd" type="button">추가</button>
	<button id="btnScore" type="button">국어성적합계</button>
	<table >
		<thead>
			<tr>
				<th>국어</th>
				<th>영어</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>40</td>
				<td>60</td>
			</tr>
			<tr>
				<td>80</td>
				<td>100</td>
			</tr>
			<tr>
				<td>60</td>
				<td>60</td>
			</tr>
		</tbody>
	</table>

	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
		
	<script type="text/javascript">
		//국어 성적 합계
		$("#btnScore").on("click", function () {
			
			var tds = $("tbody").find("tr").find("td:nth-child(1)");
			
			var sum = 0;
			
			for(td of tds){
				sum = sum + parseInt($(td).html());
			}
			alert(sum);
			
		});
		
		//추가 버튼을 클릭하면 input 태그의 값으로 <tr> 생성해서 테이블에 추가
		$("#btnAdd").on("click", function () {
			var kor = $("[name='kor']");
			var eng = $("[name='eng']");
			
			
			var tbody = $("tbody");
			
			
			$("<tr>").append( $("<td>").html($(kor).val()),
							$("<td>").html($(eng).val()) )
					 .appendTo(tbody);
			
			console.log($(kor).val());
			console.log($(eng).val());
		})
	</script>
</body>
</html>