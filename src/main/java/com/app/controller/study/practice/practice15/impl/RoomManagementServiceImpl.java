package com.app.controller.study.practice.practice15.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.study.practice.practice15.RoomDAO;
import com.app.controller.study.practice.practice15.RoomManagementService;
import com.app.controller.study.practice.practice15.dto.Room;

@Service
public class RoomManagementServiceImpl implements RoomManagementService{
	
	@Autowired
	RoomDAO roomDAO;
	
	@Override
	public List<Room> findRoomList() {
		
		List<Room> roomList = roomDAO.findRoomList();
		System.out.println("[Service]");
		return roomList;
	}
	

}
