<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bank.jsp</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	crossorigin="anonymous"></script>
</head>
<body>

	<input name="fintechUseNum">
	<button type="button" id="btnBalance">잔액조회</button>

	<div id="result"></div>

	<br>

	<div id="divacc">
		<!-- //부모한테 이벤트 걸기 -->
		<!-- <div class="acc" data-useNum="핀테크 넣기">
			<span>대구은행</span> <span>계좌번호</span>
		</div> -->
	</div>


	<script type="text/javascript">
		accountList();
		function accountList() {
			$
					.ajax({
						url : "account",

					})
					.done(
							function(result) {
								//계좌번호, 계좌일련번호를 divacc에 출력

								$("#divacc").empty();

								var list = result.res_list;
								for (var i = 0; i < list.length; i++) {

									/* var div = $("<div>");
									var span1 = $("<span>").html(list[i].bank_name);
									var span2 = $("<span>").html(
											list[i].account_num_masked);
									
									div.append(span1, span2);
									
									div.data("use-num", list[i].fintech_use_num)
										.addClass("acc");
									
									$("#divacc").append(div); */

									$("<div>")
											.addClass("acc")
											.data("use-num", list[i].fintech_use_num)
											.append($("<span>").html(list[i].bank_name))
											.append($("<span>").html(list[i].account_num_masked))
											.appendTo("#divacc");
								}

								console.log(result);
							});
		}

		function findFintechUseNum(fintech) {

			var tmp = $('[name="fintechUseNum"]');
			tmp.attr('value', fintech);

			$.ajax({
				url : "balance",
				data : {
					fintechUseNum : fintech
				},

			}).done(function(result) {
				//잔액만 div에 출력

				$("#result").empty();
				$("#result").append(result.balance_amt);

			});

		}

		$("#divacc").on("click", ".acc", function accountList() {
			var num = $(this).data("use-num");

			$.ajax({
				url : "balance",
				data : {
					fintechUseNum : num
				},

			}).done(function(result) {
				//잔액만 div에 출력
				$("#result").empty();
				$("#result").append(result.balance_amt);

			});
		});
	</script>

</body>
</html>