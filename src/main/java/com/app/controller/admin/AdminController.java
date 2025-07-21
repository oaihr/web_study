package com.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class AdminController {
	
	@Autowired
	RoomService roomService;
	
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		
		return "admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(Room room) {
		
		//값이 잘 넘어왔는지 확인
		System.out.println(room.toString());
		
		//room 정보 등록
		int result = roomService.saveRoom(room);
		System.out.println(result);
		
		return "admin/registerRoom";
	}
}
