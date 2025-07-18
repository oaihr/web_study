package com.app.controller.study.practice.practice13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Practice13Controller {
	
	@GetMapping("/practice13/hideAd")
	public String getHideAd(HttpServletRequest request) {
		
		String ck = MyCookieUtil.getCookie(request, "noAd");
		if(ck != null)
			request.setAttribute("noAd", ck);
		else
			request.setAttribute("noAd", null);
		
		return "practice/practice13/ad";
	}
	
	@PostMapping("/practice13/hideAd")
	public String postHideAd(HttpServletRequest request, HttpServletResponse response) {
		String checked = request.getParameter("check");
		
		//24시간보지않기 체크 후 요청을 했으면?? 
		//쿠키 값 저장 -> 나중에 해당 화면 접근시, 광고 표시 여부로 활용
		if(checked != null) {
			Cookie ck = MyCookieUtil.createCookie("noAd", "true", 60*60*24);
			response.addCookie(ck);
		}
		return "redirect:/practice13/hideAd";
	}
}
