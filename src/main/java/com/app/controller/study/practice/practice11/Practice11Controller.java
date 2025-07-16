package com.app.controller.study.practice.practice11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice11")
public class Practice11Controller {
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path, Model model) {
		
		if(path.equals("firsthide2")) { return "redirect:/practice11/first"; }		
		
		model.addAttribute("accessUrl", "/"+path);	
		
		return "practice/practice11/targetPage";
	}
	
	
}
