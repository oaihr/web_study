<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>param1</h1>
	
	<div>
		<form action="/request03/param2" method="post">
			<input type="text" name="name"> <br>
			<input type="text" name="count"> <br>
			<button type="submit">전송</button>
		</form>
				
	</div>
	
	<div>
		<a href="/request03/param2?name=abcname&count=998">param2로 이동</a>
	</div>
</body>
</html>