package com.app.controller.study.practice.practice10;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// request / session	/ application(거의 안건드림)

// request: 각 요청별 독립
// session: 브라우저(사용자)별로 구분 사용

@Controller
public class Practice10Controller {
	@RequestMapping("/practice10/{path}")					//HttpsSession session  바로 받을 수도 있음!
	public String a(@PathVariable String path, Model model, HttpServletRequest request) {
		model.addAttribute("path", path);
		
		if(path.equals("B")) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionPath", "FromB");
		}
		return "practice/practice10/prac10";
	}
}

