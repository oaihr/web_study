package com.app.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class RoomController {
	
	@Autowired	// 의존성 주입 방법
	RoomService roomService; 
	// 스프링이 관리하는 RoomService를 주입받아서 사용하겠다
	
	// 모든 보유 호실 정보를 보여주는 요청
	@GetMapping("/rooms")
	public String rooms(Model model) {
		
		System.out.println("[Controller] 호출 /rooms 경로");
		
		//호실정보		
		//Controller -> Service -> DAO
		List<Room> roomList = roomService.findRoomList();
		
		//화면에 보여줄 호실 데이터 -> view 데이터 전달
		model.addAttribute("roomList", roomList);
		
		return "room/rooms";
	}
}
