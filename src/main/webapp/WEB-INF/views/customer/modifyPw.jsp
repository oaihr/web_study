<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호 변경 페이지</h1>
	<form action="" method="post">
		변경할 비밀번호: <input type="password" name="pw">
		<button type="submit">변경하기</button>
	</form>
	
	<button type="button" onClick="location.href='/customer/mypage'">마이페이지로 가기</button>
</body>
</html>