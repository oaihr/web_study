package com.app.controller.study.practice.practice15.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice15CustomerController {

	
	@Autowired
	Practice15CustomerService practice15CustomerService; 
	
	//입력화면 -> 입력처리
	//get	->  post
	
	
	//고객 정보 등록 페이지로 연결
	@GetMapping("/practice15/registerCustomer")
	public String registerCustomer() {
		return "practice/practice15/customers";
	}
	
	//등록페이지에서 사용자가 뭔가 저장할 정보를 입력한 후, 등록 요청 
	// ---> POST 요청
	@PostMapping("/practice15/registerCustomer")
	public String registerCustomerAction(@ModelAttribute Practice15Customer practice15Customer) {
		// 저장할 데이터가 담긴 객체 -> DB 저장
		// Controller -> 	Service ->  DAO ->	DB
		//            DTO           DTO     DTO
		System.out.println("[Controller] registerCustomer");
		
		int result = practice15CustomerService.saveCustomer(practice15Customer);
		
		if(result > 0) {  //저장 성공
			return "practice/practice15/customers";
		} else { //저장 실패
			return "practice/practice15/customers";
		}
	}
	
}
	
	
