package com.app.controller.study.practice.practice06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.study.practice.practice06.BodyInfoDTO;

@Controller
public class Practice06Controller {
	

//스프링 요청 응답 전달하기
//
//자신의 이름, 키, 몸무게를 입력하면 신체질량지수(BMI)를 계산해서 결과를 보여주는 페이지를 만드려고 합니다.
//
//*신체질량지수(BMI) = 체중(kg) / [신장(m)]2
//사용자가 올린 이미지
//
//
//1. /practice06/ask-bmi 경로로 요청시, 화면에는
//이름 / 키 / 몸무게를 입력하는 항목과 확인하기 버튼이 있습니다.
//*버튼 submit 발생
//
//2. /practice06/result-bmi 경로로 이동하여
//요청에 따라서 컨트롤러가 비만도를 계산해서 결과를 보여줍니다.
//
//화면에는 사용자가 입력한 이름 / 키 / 몸무게가 표시되고,
//추가로 BMI 가 표시됩니다.
//
//결과가 나타나도록 화면과 서버 코드를 구현하세요.
	
	
	@RequestMapping("/practice06/ask-bmi")
	public String ask_bmi() {
		return "practice/practice06/askBMI";
	}
	
	@PostMapping("/practice06/result-bmi")
	public String result_bmi(@ModelAttribute BodyInfoDTO bodyInfo, Model model) {
		model.addAttribute("bodyInfo", bodyInfo);
		return "practice/practice06/resultBMI";
	}
}
