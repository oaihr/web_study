package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* 컴포넌트 등록이 되려면,
 *  servelt-context.xml에 설정되어있는 
 	context:component-scan base-package="com.app.controller"
 	
 	base-package 경로 위에 존재해야 함.
*/
//Controller 컴포넌트로 인식해서 스프링에 등록
@Controller	// @ : 어노테이션
public class Request01Controller {
	
	//요청 들어오는 주소별로 맵핑
	@RequestMapping("/url1") // 괄호안에 명시된 주소로 요청이 들어왔을 때 담당 설정
	public String url1() {
		
		return "url1";
		// 리턴하는 문자열의 이름을 가지고 있는 view 파일을 명시 -> view 파일로 연결
		// ViewResolover 설정
		// /WEB-INF/views/ "return view이름 문자열" .jsp
	}
	
	@RequestMapping("/url2")
	public String url2() {
		return "home";
	}
	
	@RequestMapping("/url3")
	public String url3() {
		return "url3";
	}
	
	@RequestMapping("/url4") // GET POST 구분하지 않고 둘 다 수신
	public String url4() {
		return "req/url4";
		//WEB-INF/views/ url4 .jsp
		//WEB-INF/views/req/	url4 .jsp
	}
	
	// HTTP 통신 Method = GET , POST , DELETE , PUT , PATCH
	// GET (조회 Read) , POST (저장 Insert/Write)
	
	@RequestMapping(value="/url5", method = RequestMethod.GET)	// GET만 수신
	public String url5() {
		return "req/url4";
	}
	
	//인터넷 브라우저 주소창에 주소를 입력하고 이동하는 방식 -> GET 방식 요청	
	@RequestMapping(value="/url6", method = RequestMethod.POST) // POST만 수신
	public String url6() {
		return "req/url4";
	}
	
	@GetMapping("/url7")
	public String url7() {
		return "req/url4";
	}
	
	@PostMapping("/url8")
	public String url8() {
		return "req/url4";
	}
	
	
	@GetMapping("/request01/url9")
	public String url9() {
		return "req/url4";
	}
	
	
	
	
	
}
