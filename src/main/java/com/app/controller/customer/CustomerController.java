package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class CustomerController {
	
	// 사용자서비스 (계정에 관련된 것을 통합 관리: 고객서비스/관리자서비스)
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer/signup")
	public String signup() {		
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		int result = userService.saveCustomerUser(user);
		if(result>0) {
			System.out.println("회원가입 완료");
			return "redirect:/main";
		}else {
			System.out.println("회원가입 실패");
			return "customer/signup";
		}		
	}
	
	//@GetMapping("/customer/login")
	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}
	
	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {
		
		
		//사용자가 입력한 id,pw 맞냐 DB에 존재하냐 체크
		//서비스에서 비교시, userType까지 비교
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);	
		
		System.out.println("사용자가 입력한 아이디 비번");
		System.out.println(user);
		
		User loginUser = userService.checkUserLogin(user);
		
		if(loginUser == null) {	//로그인 실패 (틀린게 있다)
			System.out.println("로그인 실패");
		}else { //아이디 맞고 비번 맞고 userType도 일치하면 -> 로그인 성공
			System.out.println("로그인 성공");
			
			//현재 로그인 성공한 사용자 아이디 -> session 영역에 저장
			session.setAttribute("loginUserId", loginUser.getId());
			
			//return "redirect:/customer/mypage"; //로그인 성공한 후, 마이페이지로 이동
			return "redirect:/main"; //로그인 성공한 후, 메인페이지로
		}
		
		return "customer/signin";
	}
	
	@GetMapping("/customer/mypage")
	public String mypage(Model model, HttpSession session) {
		
		//로그인을 했으면, 로그인 한 사용자의 정보를 보여주는 마이페이지
		
		if(session.getAttribute("loginUserId") != null) { //로그인이 된 상태
			
			String loginUserId = (String)session.getAttribute("loginUserId");
			
			//로그인 된 사용자 ID(세션에 저장되어있음)
			User user = userService.findUserById(loginUserId);
			//그 ID에 해당하는 사용자 정보 -> view에 전달
			model.addAttribute("user", user);
			
			return "customer/mypage";
		}
		//그게 아니면? 로그인이 안된 상태 -> 로그인페이지로 이동	
		return "redirect:/customer/signin";
	}
	
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		
		//세션 초기화
		session.invalidate();
		
		return "redirect:/main";
	}
	
	@GetMapping("/customer/modifyPw")
	public String modifyPw() {
		return "customer/modifyPw";
	}
	
	@PostMapping("/customer/modifyPw")
	public String modifyPwAction(User user, HttpSession session) {
		
		//view form에서 전달된 pw만 있지만 -> User 객체로 받음
		
		// 비밀번호 변경 처리(user를 넘김)	Service -> DAO -> mapper sql
		// set pw = ?
		// where id = ? (id값도 넘겨야함)		
		// 특정 id의 비밀번호만 변경
		String loginUserId = (String)session.getAttribute("loginUserId");
		user.setId(loginUserId);
		
		System.out.println("비밀번호 변경에 사용할 user 객체");
		System.out.println(user);
		
		int result = userService.modifyUserPw(user);
		if(result > 0) { //성공
			return "redirect:/customer/mypage";
		} 
		return "customer/modifyPw";
	}
	
}
