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

	<c:choose>
		<c:when test="${type == 'str'}">
			<c:forEach var="str" items="${strList}">
				${str} <br>
			</c:forEach>
		</c:when>
		<c:when test="${type == 'member'}">
			<c:forEach var="m" items="${memberList}">
				${m.id} ${m.pw} ${m.name} <br>
			</c:forEach>
		</c:when>
	</c:choose>
	
</body>
</html>