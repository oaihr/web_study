package com.app.dto.user;

import lombok.Data;

@Data
public class UserSearchCondition {
		//	 UserSearchRequestForm
	String id;
	String searchKeyword;
	String userType;
	String name;
}
