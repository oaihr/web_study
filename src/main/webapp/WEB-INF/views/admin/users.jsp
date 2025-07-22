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
	<h2>사용자 목록 조회</h2>
	<c:forEach var="user" items="${userList}">
		<p>${user.id} ${user.pw} ${user.name} 
			<c:if test= "${user.userType == 'CUS'}">사용자</c:if>
			<c:if test= "${user.userType == 'ADM'}">관리자</c:if>
		</p>
	</c:forEach>
</body>
</html>