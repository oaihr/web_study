package com.app.dto.user;

import lombok.Data;

@Data
public class UserProfileImage {
	
	String id;	//사용자 id (T_USER)
	String fileName; //파일 이름(unique) (FILE_INFO)
}
