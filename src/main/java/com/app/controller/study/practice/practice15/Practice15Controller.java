package com.app.controller.study.practice.practice15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.controller.study.practice.practice15.dto.Customer;
import com.app.controller.study.practice.practice15.dto.Room;


@Controller
public class Practice15Controller {
	
	@Autowired
	CustomerManagementService customerManagementService;
	
	@Autowired
	RoomManagementService roomManagementService;
	
	@RequestMapping("/manage/customer")
	public String customer() {
		
		List<Customer> customerList = customerManagementService.findCustomerList();
		System.out.println("[Controller]");
		return "practice/practice15/customers";
	}
	
	@RequestMapping("/manage/room")
	public String room() {
		
		List<Room> roomList = roomManagementService.findRoomList();
		System.out.println("[Controller]");
		return "practice/practice15/rooms";
	}
	
}
