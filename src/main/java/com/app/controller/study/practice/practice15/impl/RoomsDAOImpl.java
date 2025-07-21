package com.app.controller.study.practice.practice15.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.controller.study.practice.practice15.dto.Room;


@Repository
public class RoomsDAOImpl implements com.app.controller.study.practice.practice15.RoomDAO{

	@Override
	public List<Room> findRoomList() {
		// TODO Auto-generated method stub
		System.out.println("[DAO]");
		return null;
	}

}
