package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
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
