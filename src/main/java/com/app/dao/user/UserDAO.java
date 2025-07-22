package com.app.dao.user;

import org.springframework.stereotype.Repository;

import com.app.dto.user.User;

public interface UserDAO {
	
	public int saveUser(User user);
}
