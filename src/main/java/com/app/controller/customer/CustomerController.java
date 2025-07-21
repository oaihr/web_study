package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.app.service.user.UserService;

@Controller
public class CustomerController {
	
	// 사용자서비스 (계정에 관련된 것을 통합 관리: 고객서비스/관리자서비스)
	
	@Autowired
	UserService userService;
}
