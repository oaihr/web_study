package com.app.controller.study.practice.practice03;

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

@Controller
@RequestMapping("/practice03")
public class Practice03Controller {
	
	@RequestMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		
		System.out.println("/practice03/request1-1 접속");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		return "practice/practice03/prac03";
	}
	
	@GetMapping("/request1-2")
	public String request1_2(@RequestParam(required=false, defaultValue="americano") String item, 
							 @RequestParam(required=false, defaultValue="coffee") String type) {
		
		System.out.println("/practice03/request1-2 접속");
		System.out.println(item);
		System.out.println(type);
		return "practice/practice03/prac03";
	}
	
	@GetMapping("/request1-3")
	public String request1_3(@RequestParam Map<String, String> paraMap) {
		
		System.out.println("/practice03/request1-3 접속");
		System.out.println(paraMap.get("item"));
		System.out.println(paraMap.get("type"));
		return "practice/practice03/prac03";
	}
	
	@GetMapping("/request1-4")
	public String request1_4(@ModelAttribute DrinkRequestForm drinkRequestFrom) {
		
		System.out.println("/practice03/request1-4 접속");
		System.out.println(drinkRequestFrom);
		return "practice/practice03/prac03";
	}
	
	
//---------------------------------------------------------------------------------------------
	
	
	@GetMapping("viewData1-1")
	public String viewData1_1(HttpServletRequest request) {
		
		System.out.println("/viewData 1-1 접속");
		request.setAttribute("item", request.getParameter("item"));
		request.setAttribute("type", request.getParameter("type"));
		return "practice/practice03/prac03viewData";
	}
	
	@GetMapping("viewData1-2")
	public String viewData1_2(Model model, HttpServletRequest request) {
		
		System.out.println("/viewData 1-2 접속");
		model.addAttribute("item", request.getParameter("item"));
		model.addAttribute("type", request.getParameter("type"));
		return "practice/practice03/prac03viewData";
	}
	
	@GetMapping("viewData1-3")
	public ModelAndView viewData1_3(ModelAndView mav, HttpServletRequest request) {
		System.out.println("/viewData 1-3 접속");
		mav.setViewName("practice/practice03/prac03viewData");
		mav.addObject("item", request.getParameter("item"));
		mav.addObject("type", request.getParameter("type"));
		return mav;
	}
	
	@GetMapping("viewData1-4")
	public String viewData1_4(Model model, @RequestParam (required=false) String keyword) {
		System.out.println("/viewData 1-4 접속");
		
		model.addAttribute("store", "아이스크림 가게");
		model.addAttribute("food", "골라보세요");
		
		if(keyword.equals("민트초코") || keyword.equals("초코민트") || keyword.equals("초코민또") ||keyword.equals("민초")) {
			Drink drink = new Drink();
			drink.setName("민트초코");
			drink.setType("청량감");
			
			model.addAttribute(drink);
		}else {
			Drink drink = new Drink();
			drink.setName("파인애플");
			drink.setType("새콤달콤함");
			
			model.addAttribute(drink);
		}
		return "practice/practice03/prac03viewData4";
	}
}
