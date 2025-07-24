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
	
	<div>
		<form action="" method="get">
			<p>검색기준</p>
			<label>아이디 <input type="checkbox" name="id" <c:if test="${userSearchCondition.id != null }">checked</c:if>> </label>
			<label>이름 <input type="checkbox" name="name" <c:if test="${userSearchCondition.name != null }">checked</c:if>></label>
			
			<br>
				<label><input type="radio" name="userType" value="ADM" <c:if test="${userSearchCondition.userType == 'ADM' }">checked</c:if>>관리자</label>
				<label><input type="radio" name="userType" value="CUS" <c:if test="${userSearchCondition.userType == 'CUS' }">checked</c:if>>고객(사용자)</label>
			<br>
			
			<label>검색어 : <input type="text" name="searchKeyword" value="${userSearchCondition.searchKeyword}"></label>
			<button type="submit">검색</button>
		</form>		
	</div>
	
	<hr>
	<c:forEach var="user" items="${userList}">
		<p>
			<a href="/admin/user/${user.id}">
				${user.id} ${user.pw} ${user.name} 
				<c:if test= "${user.userType == 'CUS'}">사용자</c:if>
				<c:if test= "${user.userType == 'ADM'}">관리자</c:if>
			</a>
		</p>
	</c:forEach>
</body>
</html>