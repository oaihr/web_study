package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	ApiResponseHeader header; //응답시 관련 결과 코드
	T body;	//응답시 실제 넘기는 데이터 관련 정보
	
	//제네릭 Generic : 타입을 고정하지 않고 일반화해줌
}
