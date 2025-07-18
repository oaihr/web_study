<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ad-display-hide{
		display:none;
	}
</style>
</head>
<body>

	<!--  HTML 주석 -->
	<% /* JSP 서버 주석 */ %>	
	
	<c:if test="${noAd != 'true'}">
	<form action="/practice13/hideAd" method="post" id="adForm">
		<div id="adBox" style="width: 200px; height:150px; border:1px solid black; padding:5px;">
			<h3>광고 내용</h3>
			<span label for="check">24시간 보지 않기</span><input type="checkbox" id="check" name="check">
			<button type="button" onclick="btnClick()">닫기</button>
		</div>
	</form>
	</c:if>
		<h1>practice13 페이지</h1>
		
	<script>
		function btnClick(){
			const check = document.getElementById("check");
			const adBox = document.getElementById("adBox");
			const adForm = document.getElementById("adForm");
			
			if(check.checked){	//checkbox 체크 O -> form 요청 -> 서버 Post
				adForm.submit();
			}else{				//checkbox 체크 X -> 일시적으로 안보이게 -> display:none;
				//adBox.style.display = 'none';
				adBox.classList.add('ad-display-hide');
			}
		}
	</script>	
</body>
</html>