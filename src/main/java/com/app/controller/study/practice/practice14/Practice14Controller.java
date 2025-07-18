package com.app.controller.study.practice.practice14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Practice14Controller {
	
	@Autowired
	CupBean cupBean;
	
	@Autowired
	PlateBean plateBean;
	
	@GetMapping("/practice14/fullOrder")
	public String fullOrder() {
		System.out.println("컵에 담긴 음료의 이름 - "+cupBean.getCoffeebean().getName());
		System.out.println("접시에 담긴 디저트의 이름 - "+plateBean.getDessertBean().getName());
		return "practice/practice14/prac14";
	}
	
	@GetMapping("/practice14/orderCoffee")
	public String coffeeOrder() {
		System.out.println("컵에 담긴 음료의 이름 - "+cupBean.getCoffeebean().getName());
		return "practice/practice14/prac14";
	}
	@GetMapping("/practice14/orderDessert")
	public String dessertOrder() {
		System.out.println("접시에 담긴 디저트의 이름 - "+plateBean.getDessertBean().getName());
		return "practice/practice14/prac14";
	}
	
}
