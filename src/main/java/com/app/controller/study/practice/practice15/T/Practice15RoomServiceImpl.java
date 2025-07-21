package com.app.controller.study.practice.practice15.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Practice15RoomServiceImpl implements Practice15RoomService {

	@Autowired
	Practice15RoomDAO practice15RoomDAO; 
	
	@Override
	public int saveRoom(Practice15Room practice15Room) {
		
		//DAO 를 호출해서, 저장 해라~
		int result = practice15RoomDAO.saveRoom(practice15Room);
		
		return 0;
	}
	
}