package com.app.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.dto.room.RoomSearchCondition;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {
	
	//private static final Logger log = LogManager.getLogger(AdminController.class);
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		
		System.out.println("이건 println");
		log.info("이건 log.info 레벨 기록");
		
		log.error("로그 log error 레벨");
		log.warn("경고 warning");
		log.debug("debug level 로그");
		log.trace("trace level 로그");
		
		log.info("집에 들어갔다");
		log.debug("문을 열고 들어가서, 신발을 벗었다");
		log.info("손을 씻엇다");
		log.debug("핸드워시로 1분동안 깨끗이 씻었다");
		log.info("침대에 누웠다");
		
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
			log.info("registerRoom saveRoom 정보 저장: {}", room);
			
			return "redirect:/admin/rooms";
		} else { //저장 실패
			return "admin/registerRoom";
		}		
	}
	
	//관리자가 객실 관리하면서 객실 목록 확인
	@GetMapping("/admin/rooms")
	public String rooms(Model model, RoomSearchCondition roomSearchCondition) {
		
		System.out.println(roomSearchCondition);
		//rooms 페이지에 보여줄 정보
		//DB에서 조회
		//List<Room> roomList = roomService.findRoomList();
		List<Room> roomList = roomService.findRoomListByRoomSearchCondition(roomSearchCondition);
		
		model.addAttribute("roomList", roomList);
		model.addAttribute("roomSearchCondition", roomSearchCondition);
		
		return "admin/rooms";
	}
	
	
	//roomId 식별자로 구분해서, 하나의 객실에 대한 상세정보 페이지
	@GetMapping("/admin/room/{roomId}")
	public String room(@PathVariable String roomId, Model model) {
		
		Room room = roomService.findRoomByRoomId(Integer.parseInt(roomId));
		
		model.addAttribute("room", room);
		return "admin/room";
	}
	
	// /admin/removeRoom?roomId=2
	@GetMapping("/admin/removeRoom")
	public String removeRoom(HttpServletRequest request) {
		
		String roomId = request.getParameter("roomId");
		
		int result = roomService.removeRoom(Integer.parseInt(roomId));
		
		//if(result > 0)
		return "redirect:/admin/rooms";
	}
	
	//객실 정보 수정
	@GetMapping("/admin/modifyRoom")	//admin/modifyRoom?roomId=xxx
	public String modifyRoom(HttpServletRequest request) {
		
		String roomId = request.getParameter("roomId");
		//PK roomId에 해당하는 정보를 조회해서 
		Room room = roomService.findRoomByRoomId(Integer.parseInt(roomId));
		System.out.println("기존에 가지고 있는 정보 조회한 값");
		System.out.println(room);
		
		
		// 화면에 기본값으로 보여주고! -> 사용자가 수정해라~
		request.setAttribute("room", room);
		
		return "admin/modifyRoom";
	}
	
	@PostMapping("/admin/modifyRoom")
	public String modifyRoomAction(Room room) {
		
		System.out.println("수정하려고 하는 객체 값");
		System.out.println(room);
		
		//room 객체에 데이터가 저장되어 있는 상태
		// 기존값 + 수정한 값 
		int result = roomService.modifyRoom(room);
		
		if(result > 0) { //성공	목록 or 방 상세 페이지
			return "redirect:/admin/rooms"; // 방 목록
			//return "redirect:/admin/room/"+room.getRoomId(); // 해당 방 상세 페이지
		}else {	//실패	다시 수정하는 페이지로 이동
			return "rediret:/admin/modifyRoom?roomID=" + room.getRoomId();
		}		
	}
	
	
	//관리자가 사용자계정관리 -> 사용자 계정을 추가
	@GetMapping("/admin/users/add")
	public String addUser() {
		//화면연결
		return "admin/registerUser";
	}
	
	@PostMapping("/admin/users/add")
	public String addUserAction(@ModelAttribute User user) {
		
		//저장 처리 진행
//		int result = userService.saveUser(user);
		
		//사용자 저장용 서비스 메서드 활용
		int result = userService.saveCustomerUser(user);
		
		if(result > 0) { //정상 저장 처리			
			return "redirect:/admin/users";
		} else { 
			return "admin/fail";
		}
	}
	
	
	@GetMapping("/admin/users")
	public String users(Model model, UserSearchCondition userSearchCondition) {
		
		System.out.println(userSearchCondition);
		
		//if 검색조건이 있으면 -> 조건 검색
		//	 검색조건이 없으면 -> 전체 검색
		
		//List<User> userList = userService.findUserList(); //전체 조회
		List<User> userList = userService.findUserListBySearchCondition(userSearchCondition); //조건 검색
		
		model.addAttribute("userList", userList);
		model.addAttribute("userSearchCondition", userSearchCondition);
		return "admin/users";
	}
	
	@GetMapping("/admin/user/{id}")
	public String user(@PathVariable String id, Model model) {
		
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		
		return "admin/user";
	}
	
	@GetMapping("/admin/modifyUser/{id}")
	public String moidfyUser(@PathVariable String id, Model model) {
		
		//수정 페이지 (기존 값 배치)
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		
		return "admin/modifyUser";
	}
	
	@PostMapping("/admin/modifyUser")
	public String modifyUserAction(User user) {
		
		System.out.println("modifyUser 수정하려고 넘어온 User 객체");
		System.out.println(user);
		
		int result = userService.modifyUserInfo(user);
		
		if(result > 0) {
			return "redirect:/admin/user/"+ user.getId()	;
		} else {
			return "redirect:/admin/modifyUser/"+ user.getId();
		}
	}
	
	
	
	
}
