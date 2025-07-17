package com.app.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomDAO roomDAO;
	
	@Override
	public List<Room> findRoomList() {
		
		//서비스 로직 ...
		// ...
		
		//DAO를 활용해서, 실제 데이터 가져오기
		List<Room> roomList = roomDAO.findRoomList();
		
		
		return roomList;
	}

}
