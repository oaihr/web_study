package com.app.dto.user;

import lombok.Data;

@Data
public class User {
	
	String id;
	String pw;
	String name;
	String userType; // CUS / ADM
}					// 사용자 계정 구분
					// Customer / Admin
