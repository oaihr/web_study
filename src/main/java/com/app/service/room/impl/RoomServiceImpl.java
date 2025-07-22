package com.app.service.room.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Service
public class RoomServiceImpl implements RoomService{
	
	//1 어노테이션을 통한 주입
	@Autowired
	RoomDAO roomDAO;
	
	
//	//2 생성자를 통한 주입
	public RoomServiceImpl(RoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	
	//3 setter 메소드를 통한 주입
//	public void setRoomDAO(RoomDAO roomDAO) {
//		this.roomDAO = roomDAO;
//	}
	
	
	@Override
	public List<Room> findRoomList() {
		
		System.out.println("[Service] 호출 findRoomList");
		
		//서비스 로직 ...
		// ...		
		//DAO를 활용해서, 실제 데이터 가져오기
		List<Room> roomList = roomDAO.findRoomList();
		
		
		return roomList;
	}


	@Override
	public int saveRoom(Room room) {
		// room 정보 저장해라~ -> DAO
		int result = roomDAO.saveRoom(room);
		return result;
	}


	@Override
	public Room findRoomByRoomId(int roomId) {

		Room room = roomDAO.findRoomByRoomId(roomId);
		return room;
	}


	@Override
	public int removeRoom(int roomId) {

		int result = roomDAO.removeRoom(roomId);
		return result;
	}


	

}
