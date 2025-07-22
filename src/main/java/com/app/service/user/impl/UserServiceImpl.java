package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {

		// 관리자가 사용자 계정을 추가하는 상황이니까 userType은 "CUS"여야 함!
		user.setUserType("CUS");

		int result = userDAO.saveUser(user);
		return result;
	}
	
	@Override
	public int saveAdminUser(User user) {
		//관리자 계정 추가할 때 필요한 체크 로직...
		user.setUserType("ADM");
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		//사용자 계정 추가할 때 필요한 체크 로직...
		user.setUserType("CUS");
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public List<User> findUserList() {

		List<User> userList = userDAO.findUserList();
		return userList;
	}
}
