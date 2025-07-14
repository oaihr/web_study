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

	띄어 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 쓰기
	<p>${msg1}</p>
	<p>${msg2}</p>
	
	<%--	<p>${msgXml}</p>	--%>
	<c:out value="${msgXml}" escapeXml="true" />
	<br>
	<c:out value="${msg1}" escapeXml="true" />
	<br>
	<c:out value="${msg2}" escapeXml="true" />
	<br>
	
	<a href="/jstl1">jstl1 페이지로 이동</a>
	
	<button id='btn'>jstl페이지로</button>
	
	<c:url var="jstl1Url" value="/jstl1" />
	<br>
	<a href="${jstl1Url}">jstl url</a>
	
<%-- 	<c:redirect url="http://www.coupang.com" /> --%>
	
	<script>
		
		//location.href = "http://www.coupang.com";
		document.getElementById('btn').addEventListener('click', ()=>{
			location.href = "/jstl1";
		})
	</script>
</body>
</html>