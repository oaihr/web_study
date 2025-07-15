package com.app.controller.study.practice.practice09;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Practice09Controller {
	
	
//	2-1)
//	http://localhost:8080/practice09/listTest?type=member 로 요청한 경우에
//	http://localhost:8080/practice07/listTest/member 요청한 결과와 동일한 결과가 나오도록 하세요.
//	*단, url 주소는 유지 (최종 브라우저 표시 경로 : /practice09/listTest?type=member)
//
//	2-2)w
//	http://localhost:8080/practice09/listTest?type=str 로 요청한 경우에
//	http://localhost:8080/practice07/listTest/str 로 요청한 결과와 동일한 결과가 나오도록 하세요.
//	*단, url 주소도 변경 (최종 브라우저 표시 경로 : /practice07/listTest/str)
	
	
	@RequestMapping("/practice09/listTest")
	public String listTest(@RequestParam String type, Model model) {
		
		//redirect : 사용자 측에서 다시 요청을 수행 (요청 주소가 변경)
		//forward  : 서버측에서 바로 특정 경로로 연결 (요청 주소가 유지)
		
		//type : member -> forward
		//type : str -> redirect
		
		if(type.equals("member")) {
			//forward request 유지 type 
			
			return "forward:/practice07/listTest/member";
		}else if(type.equals("str")) {
			return "redirect:/practice07/listTest/str";
		}
		
		return "forward:/practice07/listTest/member";
	}
}
