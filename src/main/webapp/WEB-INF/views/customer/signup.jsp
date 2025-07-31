<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>		
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.error-msg{color:red;}
</style>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form action="" method="post">
		아이디: <input type="text" name="id" id="inputId" value="${user.id}"}> <br>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('id')}">
				<p class="error-msg">아이디 필수 입력</p>
				<p class="error-msg">${errors.getFieldError('id').defaultMessage}</p>
			</c:if>
		</spring:hasBindErrors>
		
		<button type="button" id="btn_checkDupId">중복체크</button>
		<p id="checkDupIdMsg"></p>
		
		비밀번호: <input type="password" name="pw"> <br>
		비밀번호확인: <input type="password"> <br>
		<spring:hasBindErrors name="user">
			<c:if test="${errors.hasFieldErrors('pw')}">
				<p class="error-msg">비밀번호 길이 8~12자</p>
				<p class="error-msg">${errors.getFieldError('pw').defaultMessage}</p>
			</c:if>
		</spring:hasBindErrors>
		
		이름: <input type="text" name="name" value="${user.name}"><br>
		<button type="submit">가입하기</button>
	</form>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script>
		const btn_checkDupId = document.getElementById('btn_checkDupId');
		const p_checkDupIdMsg = document.getElementById('checkDupIdMsg');
		
		
		btn_checkDupId.addEventListener('click', ()=>{
			//아이디 중복체크 버튼 누르면
			//입력한 아이디값 확인 -> 서버로 ajax 요청 -> 중복여부 확인
			
			//사용자 입력 아이디 
			let inputId = document.getElementById('inputId').value;
			console.log(inputId);
			
			// json 포맷 전송, 서버결과 json 포맷 수신
			
			// javscript 객체 타입 -> json format 변환
			let obj = {
					"id":inputId, 
					"type": "CUS"	
			};			
			
			// js obj -> JSON format	JSON.stringify
			// JSON format -> js obj	JSON.parse
			let jsonText = JSON.stringify(obj);
			
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/customer/checkDupIdJson",
				headers: {
					"Content-type":"application/json"					
				},
				data: jsonText, // 서버에 보낼 데이터 값
				//dataType: 'text',
				dataType: 'json',
				success: function(result){
					console.log('ajax success');
					console.log(result);
					//p_checkDupIdMsg
					
					//result 는 json format text -> javascript object
					//let jsObj= JSON.parse(result);
					let jsObj = result;
					
					if(jsObj.body == 'Y'){ //중복
						p_checkDupIdMsg.textContent = '중복된 아이디입니다';
						p_checkDupIdMsg.style.color = 'red';
					}else{ //중복X
						p_checkDupIdMsg.textContent = '사용가능한 아이디입니다';
						p_checkDupIdMsg.style.color = 'green';
					}
				},
				error: function(error){
					console.log(error);
				}
			})
			
// 			//id 단순텍스트 전송, 서버결과 단순텍스트 수신
// 			$.ajax({
// 				type: "POST",
// 				url: "http://localhost:8080/customer/checkDupId",
// 				headers: {
// 					"Content-type":"application/json"					
// 				},
// 				data: inputId, // 서버에 보낼 데이터 값
// 				dataType: 'text',
// 				success: function(result){
// 					console.log('ajax success');
// 					console.log(result);
// 					//p_checkDupIdMsg
					
// 					if(result == 'Y'){ //중복
// 						p_checkDupIdMsg.textContent = '중복된 아이디입니다';
// 						p_checkDupIdMsg.style.color = 'red';
// 					}else{ //중복X
// 						p_checkDupIdMsg.textContent = '사용가능한 아이디입니다';
// 						p_checkDupIdMsg.style.color = 'green';
// 					}
// 				},
// 				error: function(error){
// 					console.log(error);
// 				}
// 			})

		})
	</script>
</body>
</html>