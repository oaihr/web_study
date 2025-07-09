package com.app.controller.study.practice.practice01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/practice01")
public class Practice01Controller {
	
	@RequestMapping("/main")	
	public String main() {
		return "practice/practice01/main";
	}
	
	@RequestMapping(value = "/product/mouse", method = RequestMethod.GET)	
	public String mouse() {
		return "practice/practice01/product/mouse";
	}
	
	@GetMapping("/product/keyboard")	
	public String keyboard() {
		return "practice/practice01/product/keyboard";
	}
}
