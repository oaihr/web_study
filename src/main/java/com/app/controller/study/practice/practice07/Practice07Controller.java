package com.app.controller.study.practice.practice07;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.practice.practice07.Member;

@Controller
@RequestMapping("/practice07")
public class Practice07Controller {
	
	@RequestMapping("/listTest")
	public String listTest(@RequestParam String type, Model model) {
		model.addAttribute("type", type);
		
		System.out.println("ttttttt:"+type);

		// 파라미터 type 값에 맞춰서 필요한 연산작업만 수행하도록 나눔 
		if (type.equals("str")) {
			List<String> strList = new ArrayList<String>();
			for (int i = 1; i <= 10; i++) {
				strList.add("스트링 리스트입니다");
			}
			model.addAttribute("strList", strList);
		} else {
			List<Member> memberList = new ArrayList<Member>();
			memberList.add(new Member("아이디1", "비번1", "이름1"));
			memberList.add(new Member("아이디2", "비번2", "이름2"));
			memberList.add(new Member("아이디3", "비번3", "이름3"));
			memberList.add(new Member("아이디4", "비번4", "이름4"));
			memberList.add(new Member("아이디5", "비번5", "이름5"));
			model.addAttribute("memberList", memberList);
		}
		return "practice/practice07/prac07";
	}
	
	// 9번 문제를 위해 추가한 코드
	
	@GetMapping("/listTest/{type}")
	public String listTestAppend(@PathVariable String type, Model model) {	
		model.addAttribute("type", type);

		// 파라미터 type 값에 맞춰서 필요한 연산작업만 수행하도록 나눔 
		if (type.equals("str")) {
			List<String> strList = new ArrayList<String>();
			for (int i = 1; i <= 10; i++) {
				strList.add("스트링 리스트입니다");
			}
			model.addAttribute("strList", strList);
		} else {
			List<Member> memberList = new ArrayList<Member>();
			memberList.add(new Member("아이디1", "비번1", "이름1"));
			memberList.add(new Member("아이디2", "비번2", "이름2"));
			memberList.add(new Member("아이디3", "비번3", "이름3"));
			memberList.add(new Member("아이디4", "비번4", "이름4"));
			memberList.add(new Member("아이디5", "비번5", "이름5"));
			model.addAttribute("memberList", memberList);
		}
		return "practice/practice07/prac07";
	}
	
	
	
	
	
}
