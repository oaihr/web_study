package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;

// 데이터 소스와 통신하는 역할 
// DB 연결 역할 -> DAO, Repository
// DB:DAO, 외부 API 연동 Repository(혼용)
@Repository
public class RoomDAOImpl implements RoomDAO{
	
	//실질적인 DB 연동 처리 관련 객체
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Room> findRoomList() {
		
		System.out.println("[DAO] 호출 findRoomList");
		
		// DB에서 room 데이터 조회 -> List
		List<Room> roomList = sqlSessionTemplate.selectList("room_mapper.findRoomList");
		return roomList;
	}

	@Override
	public int saveRoom(Room room) {
		
		// room 매개변수 값 -> DB에 저장
		
									// 내가 실행할 쿼리가 위치한 식별자
									// namespace.id
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom", room);
		//insert 적용된 행의 숫자가 return 됨
		
		return result;
	}

	@Override
	public Room findRoomByRoomId(int roomId) {
		
		Room room = sqlSessionTemplate.selectOne("room_mapper.findRoomByRoomId", roomId);
		return room;
	}

}
