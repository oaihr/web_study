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
	<h2>사용자 정보 수정하는 페이지</h2>
	
	<form action="/admin/modifyUser" method="post">
<!-- 		<input type="hidden" name="id" value=${user.id}> -->
<!-- 				disabled 쓸 땐 hidden 사용 -->
		사용자 아이디: <input type="text" name="id" value=${user.id} readonly> <br>
		사용자 비밀번호: <input type="password" name="pw" value=${user.pw}> <br>
		사용자 이름: <input type="text" name="name" value=${user.name}> <br>
		
		사용자 계정 타입 구분
		<label>고객(사용자)<input type="radio" name="userType" value="CUS" <c:if test="${user.userType == 'CUS'}"> checked </c:if>></label>
		<label>관리자<input type="radio" name="userType" value="ADM" <c:if test="${user.userType == 'ADM'}"> checked </c:if>></label>
		<button type="submit">수정하기</button>
		<button type="button" onClick="location.href='/admin/user/${user.id}'">취소</button>
	</form>
</body>
</html>