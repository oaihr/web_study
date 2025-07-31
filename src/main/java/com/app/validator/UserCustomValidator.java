package com.app.validator;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class UserCustomValidator {
	
	//public static boolean validateAdminUserAdd(User user, UserValidError userValidError) {
			
	public static boolean validate(User user, UserValidError userValidError) {
		
		boolean result = true;
		
		// 유효성 검증 비교
		if (user.getId() == null || user.getId().trim() == "") {
			userValidError.setId("아이디 입력 안함");
			result = false;
		}

		if (user.getId().equals("admin")) {
			userValidError.setId("이 아이디 안됨");
			result = false;
		}
		if (user.getPw().length() < 8 || user.getPw().length() > 12) {
			userValidError.setPw("비번길이 8~12");
			result = false;
		}
		return result;
	}
}
