<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- <link href="../../resources/css/main.css" rel="stylesheet"> -->
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
	<h1>메인페이지</h1>
	
	<c:if test="${loginUserId == null}">
		<button type="button" onClick="location.href='/customer/signup'">회원가입</button>
		<button type="button" onClick="location.href='/customer/signin'">로그인</button>
	</c:if>
	<c:if test="${loginUserId != null}">
		<p>${loginUserId} 접속 중</p>
		<button type="button" onClick="location.href='/customer/logout'">로그아웃</button>
		<button type="button" onClick="location.href='/customer/mypage'">마이페이지</button>
	</c:if>
	<script src="/js/main.js"></script>
</body>
</html>