package com.app.controller.study.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.study.api.ApiDelivery;
import com.app.dto.study.api.ApiMenu;
import com.app.dto.study.api.ApiResponseDelivery;
import com.app.dto.study.api.ApiStore;
import com.app.dto.user.User;

@RestController
public class Rest03Controller {
	
	
	// API 요청에 대해 응답 -> JSON 데이터
	
	// header, body 영역으로 나눠서 응답
	
	/*
	 	{
	 	
	 		header: {},
	 		body: {}
	 	
	 	}
	  	객체 -> json
	 */
	
	@GetMapping("/rest/object1")
	public ApiMenu object1() {
		
		ApiMenu apiMenu = new ApiMenu();
		apiMenu.setName("아임파인민트티");
		apiMenu.setPrice(3000);
		return apiMenu;		
	}
	
	@GetMapping("/rest/object2")
	public List<ApiMenu> object2(){
		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		
		menuList.add(new ApiMenu("아메리카노", 1700));
		menuList.add(new ApiMenu("아임파인민트티", 3000));
		menuList.add(new ApiMenu("당근라페샌드위치", 8500));
		
		return menuList;
	}
	
	@GetMapping("/rest/object3")
	public ApiDelivery object3() {
		
		ApiDelivery apiDelivery = new ApiDelivery();
		apiDelivery.setStaffName("엄복동");
		apiDelivery.setDestination("이태원역 2번 출구");
		apiDelivery.setPhone("010-1234-5432");
		
		ApiStore apiStore = new ApiStore();
		apiStore.setName("버거킹");
		apiStore.setAddress("용산구 이태원로");
		apiStore.setTel("02-3456-5775");
		
		apiDelivery.setApistore(apiStore);
		
		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		
		menuList.add(new ApiMenu("어니언링", 2600));
		menuList.add(new ApiMenu("트러플 머쉬룸 와퍼", 8500));
		menuList.add(new ApiMenu("콰트로치즈 와퍼", 8000));
		
		apiDelivery.setMenuList(menuList);
		return apiDelivery;
	}
	
	@GetMapping("/rest/res1")
	public int res1() {
		//리턴 해주는 응답 코드
		//10 정상
		//20 서버 내부 문제
		//30 인증키 없음
		//40 파라미터 잘못 보냄
		//50 데이터 없음
		return 30;
	}
	
	@GetMapping("/rest/res2")
	public ApiResponseHeader res2() {
		
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMesasge(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		return apiResponseHeader;
	}
	
	@GetMapping("/rest/res3")
	public ApiResponseDelivery res3() {
		
		//response 헤더 영역
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMesasge(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		
		//response 바디 영역
		ApiDelivery apiDelivery = new ApiDelivery();
		apiDelivery.setStaffName("엄복동");
		apiDelivery.setDestination("이태원역 2번 출구");
		apiDelivery.setPhone("010-1234-5432");
		
		ApiStore apiStore = new ApiStore();
		apiStore.setName("버거킹");
		apiStore.setAddress("용산구 이태원로");
		apiStore.setTel("02-3456-5775");
		
		apiDelivery.setApistore(apiStore);
		
		List<ApiMenu> menuList = new ArrayList<ApiMenu>();
		
		menuList.add(new ApiMenu("어니언링", 2600));
		menuList.add(new ApiMenu("트러플 머쉬룸 와퍼", 8500));
		menuList.add(new ApiMenu("콰트로치즈 와퍼", 8000));
		
		apiDelivery.setMenuList(menuList);
		
		//최종 응답용 객체
		ApiResponseDelivery apiResponseDelivery = new ApiResponseDelivery();
		apiResponseDelivery.setHeader(apiResponseHeader);
		apiResponseDelivery.setBody(apiDelivery);
		return apiResponseDelivery;
	}
	
	@GetMapping("/rest/res4")
	public ApiResponse<User> res4() {
		
		ApiResponse<String> ar1;
		ApiResponse<ApiMenu> ar2;
		ApiResponse<ApiDelivery> ar3;
		
		ApiResponse<List<User>> ar4;
		
		ApiResponse<User> res = new ApiResponse<User>();
		
		//header
		ApiResponseHeader apiResponseHeader = new ApiResponseHeader();
		
		apiResponseHeader.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		apiResponseHeader.setResultMesasge(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		//body 는 지금 User 객체
		User user = new User();
		user.setId("idid");
		user.setPw("pwpw");
		user.setName("name");
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		
		//response header와 body에 세팅
		
		res.setHeader(apiResponseHeader);
		res.setBody(user);
		
		return res;
	}
}







