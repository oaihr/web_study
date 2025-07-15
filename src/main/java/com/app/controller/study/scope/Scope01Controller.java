package com.app.controller.study.scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Scope01Controller {
	
	// scope
	// request / session / application
	
	@GetMapping("/scope1")
	public String scope1 (Model model) {
		
		model.addAttribute("requestMsg", "이것은 model에 추가한 메세지(request scope)");
		//request 영역
		
		return "scope/scope1";
	}
	
	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {
		
		//request scope
		request.setAttribute("requestMsg", "request scope Msg");
		
		//session scope
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope Msg");		
		
		//application scope
		ServletContext app = request.getServletContext();
		app.setAttribute("applicationMsg", "application scope Msg");
		return "scope/scope2";
	}
	
	@GetMapping("/scope3")
	public String scope3() {
		return "scope/scope3";
	}
	
	@GetMapping("/scope4")
	public String scope4(HttpSession session) {
		
		session.setAttribute("newKey", "session newKey : Value");
		
		session.removeAttribute("sessionMsg"); // session scope에서 특정 기 값을 삭제
		
		session.invalidate(); // session scope에 저장된 모든 속성(키) 삭제		(세션 초기화)
		
		return "scope/scope3";
	}
}



















