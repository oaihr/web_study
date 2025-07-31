package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.user.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		// 유효성 검증 비교
		if(user.getId() == null || user.getId().trim() == "") {
			errors.rejectValue("id", "EmptyUserId", "아이디 입력 해해해");
		}
		
		if(user.getId().equals("admin")) {
			errors.rejectValue("id", "InvalidUserId", "사용할 수 없는 아이디");
		}
		if( user.getPw().length() < 8 || user.getPw().length() > 12){
			errors.rejectValue("pw", "SizeUserPw", "비번 길이 8~12글자");
		}
	}

}
