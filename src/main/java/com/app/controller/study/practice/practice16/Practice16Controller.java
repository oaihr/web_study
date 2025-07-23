package com.app.controller.study.practice.practice16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class Practice16Controller {
	
//	@Autowired
//	UserService userService;

//	MainController로 옮김
	
//	@GetMapping("/")
//	public String main() {
//		return "practice/practice16/main";
//	}
	
	
//	CustomerController로 옮김
//	@GetMapping("/customer/signup")
//	public String signup() {		
//		return "practice/practice16/signup";
//	}
//	
//	@PostMapping("/customer/signup")
//	public String signupAction(User user) {
//		int result = userService.saveCustomerUser(user);
//		if(result>0) {
//			System.out.println("회원가입 완료");
//			return "redirect:/admin/users";
//		}else {
//			System.out.println("회원가입 실패");
//			return "practice/practice16/signup";
//		}		
//	}
}
