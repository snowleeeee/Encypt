<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>${encStr }</h1>
		<div>
			<form action="decryption.do" method="post">
			<input type="hidden" id="str" name="str" value="${encStr }">
			<input type="submit" value="복호화">
			</form>
		</div>
	</div>
</body>
</html>