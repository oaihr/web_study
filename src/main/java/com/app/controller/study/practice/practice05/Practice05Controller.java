package com.app.controller.study.practice.practice05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/practice05")
public class Practice05Controller {
	
	//1) 경로별 각자 개별 페이지를 사용하는 케이스
	// 각각 페이지 만듬 pathA, pathB, pathCommonA, pathCommonB
	
	
	
	//2) A정보, B정보 2개의 페이지를 기준으로 사용하는 케이스
//	@GetMapping("/pathA")
//	public String pathA() {
//		
//		return "practice/practice05/prac05A";
//	}
//	
//	@GetMapping("/pathCommon/A")
//	public String pathCommon_A() {
//		
//		return "practice/practice05/prac05A";
//	}
//	
//	@GetMapping("/pathB")
//	public String pathB() {
//		
//		return "practice/practice05/prac05B";
//	}
//	
//	@GetMapping("/pathCommon/B")
//	public String pathCommon_B() {
//		
//		return "practice/practice05/prac05B";
//	}
	
	//2-1) 경로 모아서
//	@GetMapping(value = {"/pathA", "pathCommon/A"})
//	public String pathA() {
//		
//		return "practice/practice05/prac05A";
//	}
//	
//	
//	@GetMapping(value = {"/pathB", "pathCommon/B"})
//	public String pathB() {
//		
//		return "practice/practice05/prac05B";
//	}
	
	

	
	
	//3) pathA, PathB는 각자 페이지, pathCommon 공통 페이지에 동적 데이터 전달
	
//	@GetMapping("/pathA")
//	public String pathA() {
//		
//		return "practice/practice05/prac05A";
//	}
//	
//	@GetMapping("/pathB")
//	public String pathB() {
//		
//		return "practice/practice05/prac05B";
//	}
	
//	@GetMapping("/pathCommon/A")
//	public String pathCommon_A(Model model) {
//		
//		model.addAttribute("productName", "A");
//		return "practice/practice05/pathCommon/common";
//	}
//	
//	
//	
//	@GetMapping("/pathCommon/B")
//	public String pathCommon_B(Model model) {		
//		
//		model.addAttribute("productName", "B");
//		return "practice/practice05/pathCommon/common";
//	}
	
	
	
//	// +pathCommon/pathVariable 형태로 사용 
//	
//	@GetMapping("/pathCommon/{productName}")
//	public String pathCommon(@PathVariable String productName, Model model) {
//		
//		// 경로에 있는 값 productName -> DB 조회
//		// 올바른 값인지 검증
//		// 그 정보에 맞는 데이터 획득 후 -> 화면에 전달		
//		
//		model.addAttribute("productName", productName);
//		return "practice/practice05/pathCommon/common";
//	}
//	
	

	
	
	
	//4) 모든 경로가 동일한 공통 페이지 사용 케이스
	
//	@GetMapping("/pathA")
//	public String pathA(Model model) {
//		model.addAttribute("productName", "A");
//		return "practice/practice05/pathCommon/common";
//	}
//	
//	@GetMapping("/pathCommon/A")
//	public String pathCommon_A(Model model) {
//		model.addAttribute("productName", "A");
//		return "practice/practice05/pathCommon/common";
//	}
//	
//	@GetMapping("/pathB")
//	public String pathB(Model model) {
//		model.addAttribute("productName", "B");
//		return "practice/practice05/pathCommon/common";
//	}
//	
//	@GetMapping("/pathCommon/B")
//	public String pathCommon_B(Model model) {
//		model.addAttribute("productName", "B");
//		return "practice/practice05/pathCommon/common";
//	}
	
	
	// 내가 한 방식 ================================================================================
//	@RequestMapping("/practice05/{path}")
//	public String practice05_path(@PathVariable String path, HttpServletRequest request) {
//		System.out.println("/practice05/{path} 요청");
//		System.out.println(path);
//		if(path.equals("pathA")) {
//			request.setAttribute("type", "A");
//		}else if(path.equals("pathB")) {
//			request.setAttribute("type", "B");		
//		}
//		
//		return "practice/practice05/prac05";
//	}
//	
//	@RequestMapping("/practice05/pathCommon/{path}")
//	public String practice05_pathCommon(@PathVariable String path, HttpServletRequest request) {
//		System.out.println("/practice05/pathCommon/{path} 요청");
//		System.out.println(path);
//		if(path.equals("A")) {
//			request.setAttribute("type", "A");
//		}else if(path.equals("B")) {
//			request.setAttribute("type", "B");		
//		}		
//		return "practice/practice05/prac05";
//	}
	
	
	
	
	
	
	
	
}
