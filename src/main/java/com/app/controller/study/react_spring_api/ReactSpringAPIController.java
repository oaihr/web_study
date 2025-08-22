package com.app.controller.study.react_spring_api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.study.DrinkItem;
import com.app.dto.study.Member;
import com.app.util.JwtProvider;
import com.app.util.LoginManager;

@RestController
public class ReactSpringAPIController {
	
	// API 통신용 컨트롤러
	
	@GetMapping("/api/getMsg")
	public String getMsg() {
		System.out.println("api/getMsg");
		
		return "spring rest api msg";
	}
	
	@GetMapping("/api/getDrinks")
	public List<DrinkItem> getDrinks() {
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("아메리카노", "커피"));
		drinkList.add(new DrinkItem("민트티", "차"));
		drinkList.add(new DrinkItem("바닐라아이스크림", "아이스크림"));
		
		// Service -> DAO -> DB
		
		return drinkList;
	}
	
	@GetMapping("/api/getDrinksDiv")
	public List<DrinkItem> getDrinksDiv(HttpServletRequest request) {
		
		String type = request.getParameter("type");
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		// 요청 type에 따라서 각각 다른 데이터 조회
		// where type = '커피'	where type = '차'
		
		if(type != null) {
			
			if(type.equals("커피")) {
				drinkList.add(new DrinkItem("에스프레소", "커피"));
				drinkList.add(new DrinkItem("카페모카", "커피"));
				drinkList.add(new DrinkItem("샤케라또", "커피"));
			}
			
			if(type.equals("차")) {
				drinkList.add(new DrinkItem("페퍼민트티", "차"));
				drinkList.add(new DrinkItem("얼그레이티", "차"));
				drinkList.add(new DrinkItem("녹차", "차"));
			}
		}
		
		return drinkList;
	}
	
	// String(num)	{id: ..., name: ..., type: ...}
	// @RequestBody String -> 파싱
	// @RequestBody 객체타입 DTO(자동 파싱)
	@PostMapping("/api/getDrinksNum")	
	public List<DrinkItem> getDrinksNum(@RequestBody String num){
		System.out.println(num);
		
		List<DrinkItem> drinkList = new ArrayList<DrinkItem>();
		drinkList.add(new DrinkItem("name"+num, "type"+num));
		
		return drinkList;
	}
	
	// 로그인
	@PostMapping("/api/login")
	public String login(@RequestBody Member member, HttpServletRequest request) {
		
		System.out.println(member.getId());
		System.out.println(member.getPw());
		
		// id pw 값 -> 서비스 -> DAO -> DB 사용자 계정정보 비교
		
		// 로그인 성공 return "ok"
		// 로그인 실패 return "no"
		// return apiResponse (header, body)		
		// Y/N	1,2,3,4(resultCode)
		
		// 로그인 성공으로 간주 -> ok 리턴
		
		// Session 로그인 여부 처리
		LoginManager.setSessionLoginUserId(request, member.getId());
		
		return "ok";
	}
	
	@PostMapping("/api/loginCheck")
	public String loginCheck(HttpServletRequest request) {
		
		if(LoginManager.isLogin(request)) {
			String loginId = LoginManager.getLoginUserId(request);
			System.out.println(loginId);
			return "login user : " + loginId;
		} else {
			return "Not Login";
		}
	}
	
	@PostMapping("/api/loginJWT")
	public String loginJWT(@RequestBody Member member, HttpServletRequest request) {
		
		//JWT JSON Web Token ( 인증 정보를 담은 토큰(문자열) )
		
		System.out.println(member.getId());
		System.out.println(member.getPw());
		
		// 계정 정보 확인 -> DB 비교 -> 성공? 실패?
		// 성공으로 간주
		
		//JWT AccessToken 발행 -> 전달
		String accessToken = JwtProvider.createAccessToken(member.getId());
		System.out.println("로그인한 아이디 : " + member.getId());
		System.out.println("발행하는 JWT accessToken : " + accessToken);
		
		// 토큰을 return -> API를 호출한 사용자에게 응답
		return accessToken;
	}
	
	@PostMapping("/api/loginCheckJWT")
	public String loginCheckJWT(HttpServletRequest request) {
		//token을 가져와서 -> 유효한 토큰인지 체크 -> 맞으면 누가 로그인했는지 id 확인
		// ---> 필요한 로직 수행 (id기반으로 DB조회) oooo처리 -> return
		
		String accessToken = JwtProvider.extractToken(request);
		System.out.println("request에서 추출한 토큰 값 : "+accessToken);
		
		if(accessToken == null) { // 인증 토큰 정보가 포함되지 않은 요청
			return "no"; // 응답코드, ApiResponse
		}
		
		//토큰 검증
		
		//토큰이 유효한 토큰인지 확인 true/false
		System.out.println(JwtProvider.isVaildToken(accessToken)); 
		
		//유효한 토큰이면? 그 토큰 안에 저장된 사용자 id를 확인해 볼 수 있다.
		if(JwtProvider.isVaildToken(accessToken)) {
			String userId = JwtProvider.getUserIdFromToken(accessToken);
			
			System.out.println("토큰에서 추출한 사용자id : "+userId);
			
			return "login user : "+userId ;
		}
		
		return "no";
	}
}






