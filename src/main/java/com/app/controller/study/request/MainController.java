package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main")
	public String main() {
		return "req/main";
	}
}
