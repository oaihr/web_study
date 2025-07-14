<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>신체 정보 입력 페이지</h1>
	<form action="/practice06/result-bmi" method="post">
		<span label for="name">이름: </span> <input type="text" name="name" id="name"><br>
		<span label for="height">키(cm): </span> <input type="number" name="height" id="height"><br>
		<span label for="weight">몸무게(kg): </span><input type="number" name="weight" id="weight"><br>
		<button type="submit">입력</button>
	</form>
</body>
</html>