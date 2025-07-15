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
	<h2>서버에서 전체 리스트를 넘기고, 화면에서 JSTL로 구분해서 출력했을 때</h2>
	<c:choose>
		<c:when test="${auth == 'basic'}">
			<h1>basic 페이지</h1>
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == 'basic'}">
					<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'manager'}">
			<h1>manager 페이지</h1>
			<c:forEach var="member" items="${memberList}">
				<c:if test="${member.type == 'manager'}">
					<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
				</c:if>
			</c:forEach>
		</c:when>
		<c:when test="${auth == 'admin'}">
			<h1>admin 페이지</h1>
			<c:forEach var="member" items="${memberList}">
				<p>${member.id} ${member.pw} ${member.name} ${member.type}</p>
			</c:forEach>
		</c:when>
	</c:choose>
	
	<h2>서버에서 화면에 보여줄 리스트를 필터링하고 넘겨줬을 떄</h2>
	<c:forEach var="m" items="${viewMemberList}">
		<p>${m.id} ${m.pw} ${m.name} ${m.type}</p>
	</c:forEach>
</body>
</html>