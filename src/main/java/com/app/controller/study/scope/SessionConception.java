package com.app.controller.study.scope;

import java.util.HashMap;
import java.util.Map;

public class SessionConception {
	
	/*	사용자(브라우저)			-(요청)->		서버
		쿠키값(JSESSIONID)	<-(응답)-		서버
	
	
		사용자	-(요청:쿠키값포함)->		서버: 쿠키값 확인
										 -> JSESSIONID key값 -> 그 세션의 저장공간 -> session.setAttribute
		
		Map
		key:JSESSIONID	Value:저장공간(SessionStorage)
									 => 저장공간임 key, value를 갖음
	*/
	
	public static void main(String[] args) {
		
		Map<String, SessionStorage> sessionMap = new HashMap<String, SessionStorage>();
		
		//새로운 사용자 접근 -> 11AA
		
		sessionMap.put("11AA", new SessionStorage()); //11AA 세션에 대한 저장공간 생성
		
		SessionStorage session = sessionMap.get("11AA"); // value: SessionStorage
		session.setAttribute("fromBMsg", "fromB");
		session.setAttribute("msg", "hi hello");
		
		//또 다른 사용자 접근 -> 22BB
		sessionMap.put("22BB", new SessionStorage()); //22BB 세션에 대한 저장공간 생성
		
		session = sessionMap.get("11AA");
		session = sessionMap.get("22BB");
		session.setAttribute("msg2", "hi");
		session.setAttribute("msg3", "hello");
	}
}

class SessionStorage{
	
	Map<String, Object> storage;
	
	public SessionStorage() {
		storage = new HashMap<String, Object>();
	}
	
	public void setAttribute(String key, Object value) {
		storage.put(key, value); //storage Map에 값 저장
	}
	
	public void removeAttribute(String key) {
		storage.remove(key); // 특정 기값으로 삭제
	}
	
	public void invalidate() {
		storage.clear(); //전부삭제 (초기화)
	}
}