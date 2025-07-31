package com.app.dto.user;

import lombok.Data;

@Data
public class UserValidError {
	// 유효성 검증 결과 저장용
	// 값 X(null) 통과
	// 값 O : 검증 실패, 에러 메세지 저장
	String id;
	String pw;
	String name;
	String userType;
}
