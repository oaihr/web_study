package com.app.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		if(result > 0) { //정상적으로 저장 성공
			return "redirect:/admin/rooms";
		} else { //저장 실패
			return "admin/registerRoom";
		}		
	}
	
	//관리자가 객실 관리하면서 객실 목록 확인
	@GetMapping("/admin/rooms")
	public String rooms(Model model) {
		
		//rooms 페이지에 보여줄 정보
		//DB에서 조회
		List<Room> roomList = roomService.findRoomList();
		model.addAttribute("roomList", roomList);
		
		return "admin/rooms";
	}
}
