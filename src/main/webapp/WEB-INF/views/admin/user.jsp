<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 페이지</h1>
	<h2>사용자 상세 페이지</h2>
	
	<p>아이디 : ${user.id}</p> 
	<p>이름 : ${user.name}</p>
	<p> 
		<c:if test= "${user.userType == 'CUS'}">사용자</c:if>
		<c:if test= "${user.userType == 'ADM'}">관리자</c:if>
	</p>
	<div>
		<button type="button" onClick="location.href='/admin/modifyUser/${user.id}'">수정하기</button>
		<button type="button" onClick="location.href='/admin/users'">사용자 목록보기</button>
	</div>
</body>
</html>