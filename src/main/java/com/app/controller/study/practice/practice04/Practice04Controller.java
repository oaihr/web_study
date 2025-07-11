package com.app.controller.study.practice.practice04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.practice.practice03.Drink;
import com.app.dto.study.practice.practice03.DrinkRequestForm;
import com.app.dto.study.practice.practice04.CategoryProductRequestForm;
import com.app.dto.study.practice.practice04.StoreJewel;

@Controller
@RequestMapping("/practice04")
public class Practice04Controller {
	
	// http://localhost:8080/practice04/request1-x?category=100&product=4000
	@GetMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		
		System.out.println("/practice04/request1-1 접속");
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		return "practice/practice04/prac04";
	}
	
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam(required=false) String category, 
							 @RequestParam(required=false) String product) {
		
		System.out.println("/practice04/request1-2 접속");
		System.out.println(category);
		System.out.println(product);
		return "practice/practice04/prac04";
	}
	
	@GetMapping("/request1-3")
	public String request1_3(@ModelAttribute CategoryProductRequestForm categoryProductRequestForm) {
		
		System.out.println("/practice04/request1-3 접속");
		System.out.println(categoryProductRequestForm);
		return "practice/practice04/prac04";
	}
	
	@GetMapping("/request1-4")
	public String request1_4(@RequestParam Map<String, String> paraMap) {
		
		System.out.println("/practice03/request1-4 접속");
		System.out.println(paraMap.get("category"));
		System.out.println(paraMap.get("product"));
		return "practice/practice04/prac04";
	}
	
//------------------------------------------------------------------------------------------------
	
	// http://localhost:8080/practice04/viewData1-x
	
	@GetMapping("viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		
		System.out.println("/viewData 1-1 접속");
		request.setAttribute("store", "보석가게" );
		request.setAttribute("jewel", "루비");
		return "practice/practice04/prac04";
	}
	
	@GetMapping("viewData1-2")
	public String viewData1_2(Model model) {
		
		System.out.println("/viewData 1-2 접속");
		model.addAttribute("store", "보석가게");
		model.addAttribute("jewel", "사파이어");
		return "practice/practice04/prac04";
	}
	
	@GetMapping("viewData1-3")
	public ModelAndView viewData1_3(ModelAndView mav) {
		System.out.println("/viewData 1-3 접속");
		mav.setViewName("practice/practice04/prac04");
		mav.addObject("store", "보석가게");
		mav.addObject("jewel", "오팔");
		return mav;
	}
	
	@GetMapping("viewData1-4")
	public String viewData1_4(@ModelAttribute StoreJewel storeJewel) {
		System.out.println("/viewData 1-4 접속");
		
		storeJewel.setStore("보석가게");
		storeJewel.setJewel("자수정");
		
		return "practice/practice04/prac04";
	}
}
