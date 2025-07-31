package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequestForm {
	// 특정 화면에서 요청 들어온 데이터를 담아야하는 용도 DTO
	// 화면별로 요청시 검증해야하는 기준이 다른 경우
	// 요청Form 별 객체를 구분해서 유효성 기준 작성

	//필수입력 빈칸X 	뷰에서 ${errors.getFieldError('id').defaultMessage}
	@NotBlank(message = "아이디 필수얌")
	String id;
	
	//입력 길이 제한			뷰에서 ${errors.getFieldError('pw').defaultMessage}
	@Size(min=8, max=12, message = "비밀번호 길이 체크해")
	String pw;
	String name;
	String userType; // CUS / ADM
}					// 사용자 계정 구분
					// Customer / Admin

// UserRequestForm 담긴 -> User 객체에 옮겨담아서 -> userService.saveUser
