package com.app.common;

public interface CommonCode {
	
	//프로젝트 서비스 내에서 사용하는 모든 코드들을 공통코드라 부르며, 모아둔 파일
	
	//User
	public static final String USER_USERTYPE_CUSTOMER = "CUS";
	public static final String USER_USERTYPE_ADMIN = "ADM";
	
	//Room
	//interface내에서 선언한 변수는 자동으로 static final이 붙음 (상수가 됨)
	public String ROOM_VIEWTYPE_OCEAN = "OCN";
	public String ROOM_VIEWTYPE_CITY = "CTY";
	public String ROOM_VIEWTYPE_MOUNTAIN = "MOT";
}
