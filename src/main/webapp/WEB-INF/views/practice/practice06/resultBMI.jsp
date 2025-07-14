<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BMI 계산 결과</h1>
	<p>이름: ${bodyInfo.name}</p>
	<p>키: ${bodyInfo.height}</p>
	<p>몸무게: ${bodyInfo.weight}</p>
	<h3>BMI: ${bodyInfo.weight / ((bodyInfo.height/100) * (bodyInfo.height/100))}</h3>
</body>
</html>