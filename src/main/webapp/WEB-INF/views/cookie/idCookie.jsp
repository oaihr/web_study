<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>idCookie</h1>
	
<!-- 	<form action="/idCookie" method="post"> -->		
	<form action="" method="post">	
		
		아이디 : <input type="text" name="id" value="${remember}" }> <br>
		비번 : <input type="password" name="pw"> <br>
		아이디 기억 <input type="checkbox" name="remember" value="true"> <br>
		
		<button type="submit">로그인</button>
	</form>
</body>
</html>