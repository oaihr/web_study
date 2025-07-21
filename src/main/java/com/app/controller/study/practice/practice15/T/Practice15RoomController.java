package com.app.controller.study.practice.practice15.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Practice15RoomController {

	@Autowired
	Practice15RoomService practice15RoomService;
	
	@GetMapping("/practice15/registerRoom")
	public String registerRoom() {
		return "practice/practice15/registerRoom";
	}
	
	@PostMapping("/practice15/registerRoom")
	public String registerRoomAction(@ModelAttribute Practice15Room practice15Room) {
		//입력한 데이터 요청받는
		
		//저장하는 과정  (service)
		int result = practice15RoomService.saveRoom(practice15Room);
		
		return "practice/practice15/registerRoom";
	}
}
