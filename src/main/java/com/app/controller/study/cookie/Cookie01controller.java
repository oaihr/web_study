package com.app.controller.study.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Cookie01controller {
	
	@GetMapping("/saveCookie")
	public String saveCookie(HttpServletResponse response) {
		
		//서버에서 쿠기 생성 -전달-> 사용자(브라우저)
		//						쿠키 있으면 -> 쿠키 저장
		
		Cookie ck1 = new Cookie("menu", "donkatsu");
		ck1.setMaxAge(60 * 60 * 12); // 쿠키의 수명  초단위
		
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("today", "WED");
		ck2.setMaxAge(30);
		
		response.addCookie(ck2);
		
		//쿠키에는 띄어쓰기 -> URLEncode 처리
		try {
			String value = URLEncoder.encode("plus 15", "UTF-8");

			Cookie ck3 = new Cookie("temperature", value);
			ck3.setMaxAge(30);

			response.addCookie(ck3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//util 사용
		Cookie ck4 = MyCookieUtil.createCookie("ck4Name", "ck4Value");
		Cookie ck5 = MyCookieUtil.createCookie("ck5Name", "ck5Value", 3600);		
		
		return "cookie/saveCookie";
	}
	
	@GetMapping("/removeCookie")
	public String removeCookie(HttpServletResponse response) {
		
		Cookie ck1 = new Cookie("menu", "vvvv");
		ck1.setMaxAge(0);	// 수명 0 -> 브라우저 인식 -> 수명0 쿠키 처리 -> 지움
		
		response.addCookie(ck1);
		
		//util 사용
		Cookie ckk = MyCookieUtil.createCookieForRemove("abc");
		response.addCookie(ckk);
		
		return "cookie/saveCookie";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		
		String menu = null;
		for(Cookie ck : cookies) {			
			System.out.println(ck.getName()+" "+ck.getValue());			
			
			if(ck.getName().equals("menu")) {
				menu = ck.getValue();
			}
			
			if(ck.getName().equals("temperature")) {
				try {
					System.out.println("decode: "+URLDecoder.decode(ck.getValue(), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//Util 사용
		menu = MyCookieUtil.getCookie(cookies, "menu");
		
		request.setAttribute("menu", menu);
		
		// 둘 다 가능 (메서드 오버로딩)
		String temperature = MyCookieUtil.getCookie(cookies, "temperature");
		temperature = MyCookieUtil.getCookie(request, "temperature");
		
		return "cookie/readCookie";
	}
	
	@GetMapping("/readCookie2")
	public String readCookie2(@CookieValue(required=false) String menu, @CookieValue(required=false) String temperature) {
		
		System.out.println(menu);
		System.out.println(temperature);
		
		return "cookie/readCookie";
	}
	
	
	
}
