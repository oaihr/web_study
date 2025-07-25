package com.app.dto.study.api;

import java.util.List;

import lombok.Data;

@Data
public class ApiDelivery {
	String staffName; //배달 기사 이름
	String destination; //배달 목적지 주소
	String phone; //배달 기사 전화번호
	
	ApiStore apistore; //어디 매장에서
	List<ApiMenu> menuList; //무슨 메뉴를 주문했는가
}
