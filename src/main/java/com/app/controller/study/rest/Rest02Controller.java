package com.app.controller.study.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController	//Controller 역할인데, +RestAPI 형식의 통신용 컨트롤러
public class Rest02Controller {	//내부 메소드가 모두 RestAPI 형식 text를 리턴! 작동
	
	@GetMapping("/rest/rest04")
	public String rest04() {
		return "rest/rest04";
	}
	
	@GetMapping("/rest/rest05")
	public String rest05() {
		return "simple text return /rest/rest05";
	}
	
	
	@GetMapping("/rest/rest06")
	public String rest06() {
		//return text -> json format
	
		//json 포맷으로 만들기
		
		/*
		 User	abc,abc123,abcname,CUS
		 
		 1. 단순 텍스트로 반환
		 	return "abc,abc123,abcname,CUS";
		 	return "abc,abc123,abcname,CUS";
		
		 2. JSON 포맷으로 반환
		 데이터 전달용 -> 데이터 표현하는 규칙 -> JSON
			 {
			 	"id":"abc",
			 	"pw":"abc123",
			 	"name":"abcname",
			 	"userType":"CUS"
			 }
		 */
		//1) 수동으로 포맷해서 작성
//		String result = "{\r\n"
//				+ "\"id\":\"abc\",\r\n"
//				+ "\"pw\":\"abc123\",\r\n"
//				+ "\"name\":\"abcname\",\r\n"
//				+ "\"userType\":\"CUS\"\r\n"
//				+ "}";
		
		//2) json-simple 라이브러리를 활용해서 json 포맷으로 반환
//		JSONObject obj = new JSONObject();
//		obj.put("id", "abc");
//		obj.put("pw", "abc123");
//		obj.put("name", "abcname");
//		obj.put("userType", "CUS");
//		
//		System.out.println(obj.toJSONString());
//		
//		String result = obj.toJSONString();
		
		//3) jackson 라이브러리 활용
		//객체 -> JSON 포맷 변환
		
		
		//객체 생성
		User user = new User();
		user.setId("abc");
		user.setPw("abc123");
		user.setName("abcname");
		//user.setUserType("CUS");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		
		try {
			//객체 -> JSON 포맷 String 으로 변환
			result = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		//JSON String return
		return result;		
	}	
	
	@GetMapping("/rest/rest07")
	public User rest07() {
		
		// 객체 생성
		User user = new User();
		user.setId("abc");
		user.setPw("abc123");
		user.setName("abcname");
		// user.setUserType("CUS");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		//@ResponseBody or @RestController
		//REST API 통신으로 response body 에 텍스트로 반환하는 상황!
		//객체 리턴! -> 객체를 JSON 포맷으로 변환 -> return
		//**조건: jackson 라이브러리 존재! (의존성 추가)
		return user;
	}
	
	
	
}
