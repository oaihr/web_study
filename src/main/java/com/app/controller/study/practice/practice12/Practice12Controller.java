package com.app.controller.study.practice.practice12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice12Controller {
	
	
	@GetMapping("/practice12/login")
	public String login() {
		return "practice/practice12/login";
	}
	
	@PostMapping("/practice12/login")
	public String loginAction(HttpServletRequest request) {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		
		//로그인 성공으로 간주하고, 로그인한 사용자 id를 세션에 저장  
		//					-> 나중에 다른 request에서도 session에 접근 및 데이터 조회 가능
		HttpSession session = request.getSession();
		session.setAttribute("loginId", request.getParameter("id"));
		session.setAttribute("count", 0);  //해당 세션에 대한 count 값 초기화
		
//		return "practice/practice12/count";		
		return "redirect:/practice12/count";
	}
	
	
	@GetMapping("/practice12/count")
	public String count(HttpSession session, Model model) {
		
		//session.getAttribute("loginId");  
		
		
		//로그인한 사용자가 있으면->count값도 초기화되서 있다
		//count가 있어야 처리한다!  
		//if(session.getAttribute("count") != null)
		
		if(session.getAttribute("loginId") != null) {
			//count 계산
			// 기존 count = 기존 count + 1 
			session.setAttribute("count", ( (Integer)(session.getAttribute("count")) + 1 ));    
		} else {
			model.addAttribute("count", 0);
		}
		
		
		return "practice/practice12/count";	
	}
	
	@GetMapping("/practice12/logout")
	public String logout(HttpSession session) {
		
		//세션을 삭제하고 
		//count 페이지로 이동
		
		//session.removeAttribute("loginId");
		//session.removeAttribute("count");
		session.invalidate();
		
		return "redirect:/practice12/count";
	}
}