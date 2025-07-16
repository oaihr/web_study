package com.app.controller.study.practice.practice11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/practice11")
public class Practice11Controller {
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path, Model model, HttpSession session) {
		
		if(path.equals("firsthide2")) { 
			return "redirect:/practice11/first"; 
		}
		
		if(path.equals("firsthide3")) {			
			// firsthide3에 접근했었다는 의미를 세션 영역에 저장
			session.setAttribute("accessUrl", "/firsthide3");
			// 리다이렉트 시 쿼리 파라미터로 붙지 않도록 Model에 추가하지 않음
			return "redirect:/practice11/first";
		}			
		
		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/first")
	public String firstPage(Model model, HttpSession session) {
		// 세션에 저장된 accessUrl이 있다면 Model에 추가
		if (session.getAttribute("accessUrl") != null) {
			model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
			session.removeAttribute("accessUrl"); // 사용 후 세션에서 제거 (선택 사항)
		} else {
			// first 경로로 직접 접근했거나, hide3를 거치지 않은 경우에 대한 처리
			model.addAttribute("accessUrl", "/first"); 
		}
		return "practice/practice11/targetPage"; // first.jsp 또는 targetPage.jsp 등 원하는 뷰 이름
	}
}
