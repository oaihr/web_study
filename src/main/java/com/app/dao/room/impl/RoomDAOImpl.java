package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

// 데이터 소스와 통신하는 역할 
// DB 연결 역할 -> DAO, Repository
// DB:DAO, 외부 API 연동 Repository(혼용)
@Repository
public class RoomDAOImpl implements RoomDAO{

	@Override
	public List<Room> findRoomList() {
		
		System.out.println("[DAO] 호출 findRoomList");
		// DB에서 room 데이터 조회 -> List
		
		return null;
	}

}
