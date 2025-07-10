package com.app.controller.study.viewdata;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.Product;

@Controller
public class ViewData01Controller {
	
	/*
	  
	 FE 			---> BE서버(Spring)		---> DB
	 외부BE 				return "view이름"
	 (html/css/js) 		<--- view 지원(jsp)
	  
	 */
	
	@GetMapping("/viewData1")
	public String viewData1(HttpServletRequest request) {
		
		//localhost:8080/viewData1?p1=aaa
		
		System.out.println("/viewData1 요청");
		System.out.println(request.getParameter("p1"));
		
		//request.setAttribute(key, value);
		request.setAttribute("store", "김밥천국");
		request.setAttribute("menu", "스팸정식");
		
		return "viewData/viewData1";
	}
	
	@GetMapping("/viewData2")
	public String viewData2(Model model) {
		
		System.out.println("/viewData2 요청");
		model.addAttribute("store", "맘스터치");
		model.addAttribute("menu", "싸이버거");
		
		return "viewData/viewData1";
	}
	
	@GetMapping("/viewData3")
	public ModelAndView viewData3() {
		
		System.out.println("/viewData3 요청");
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("viewData/viewData1");
		mav.addObject("store", "달식당");
		mav.addObject("menu", "돈까스");
		
		return mav;
	}
	
	@GetMapping("/viewData4")
	public ModelAndView viewData4(ModelAndView mav) {
		
		System.out.println("/viewData4 요청");
		
		mav.setViewName("viewData/viewData1");
		mav.addObject("store", "달식당");
		mav.addObject("menu", "김밥");
		
		return mav;		
	}
	
	@GetMapping("/viewData5")
	public String viewData5(Model model) {
		
		System.out.println("/viewData5 요청");
		
		//객체 전달
		Product product = new Product();
		product.setId("idid");
		product.setName("namepp");
		product.setPrice(9900);
		
		model.addAttribute("store", "맘스터치");
		model.addAttribute("menu", "싸이버거");
		
		model.addAttribute("product", product);
		return "viewData/viewData5";
	}
	
	@GetMapping("/viewData6")
	public String viewData6(HttpServletRequest request) {
		
		//.../viewData6?searchKeyword=커피
		System.out.println("/viewData6 요청");		
		
		//요청 들어온 파라미터
		//request.getParameter(null);
		
		//view Data 전달
		//request.setAttribute(key, value);
		
		String searchKeyword = request.getParameter("searchKeyword");
		
		request.setAttribute("store", "카페");
		request.setAttribute("menu", "메뉴골라골라");		
		
		if(searchKeyword.equals("커피")) {
			Product product = new Product();
			product.setId("cfe");
			product.setName("아메리카노");
			product.setPrice(2500);
			
			request.setAttribute("product", product);
		}else {
			Product product = new Product();
			product.setId("tea");
			product.setName("허브티");
			product.setPrice(3800);
			
			request.setAttribute("product", product);
		}
		
		
		return "viewData/viewData5";
	}
	
	@GetMapping("/viewData7")
	public String viewData7(Model model, @RequestParam(required = false) String searchKeyword) {
										//HttpServletRequest request
										//Map<String,String> paraMap
		//.../viewData6?searchKeyword=커피
		System.out.println("/viewData7 요청");		
		
		//요청 들어온 파라미터
		//request.getParameter(null);
		
		//view Data 전달
		//request.setAttribute(key, value);
		
		// 파라미터 searchKeyword 값 받기
		// String searchKeyword = request.getParameter("searchKeyword");
		// paraMap.get("searchKeyword");
		
//		view에 데이터를 담아서 보내겠다!!!
		
		model.addAttribute("store", "카페");
		model.addAttribute("menu", "메뉴골라골라");		
		
		if(searchKeyword.equals("커피")) {
			Product product = new Product();
			product.setId("cfe");
			product.setName("아메리카노");
			product.setPrice(2500);
			
			model.addAttribute("product", product);
		}else {
			Product product = new Product();
			product.setId("tea");
			product.setName("허브티");
			product.setPrice(3800);
			
			model.addAttribute("product", product);
		}
		
		
		return "viewData/viewData5";
	}
	
	
	
}
