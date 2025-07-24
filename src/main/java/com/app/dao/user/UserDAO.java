package com.app.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;

public interface UserDAO {
	
	public int saveUser(User user);

	public List<User> findUserList();
	
	public User findUserById(String id);
	
	public User checkUserLogin(User user);
	
	public int modifyUserPw(User user);

	public int modifyUserInfo(User user);

	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition);
}
