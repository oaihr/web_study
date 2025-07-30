package com.app.scheduler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.app.service.room.RoomService;
import com.app.service.user.UserService;

public class DailySalesScheduler {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoomService roomService;
	
	@Scheduled(cron ="0/5 * * * * *")
	public void testScheduler() {
		System.out.println("testScheduler"+ LocalDateTime.now());
	}
	
	@Scheduled(cron ="0 0 2 * * *")
	public void dailysalesTask() {
		userService.findUserById(null);
		roomService.findRoomList();
		//일일정산
		
		//서비스 호출 -> 정산 쿼리
		
		//데이터 API 호출 -> DB저장
	}
}
