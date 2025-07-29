package com.app.service.user.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.dto.user.UserSearchCondition;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {

		// 관리자가 사용자 계정을 추가하는 상황이니까 userType은 "CUS"여야 함!
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		int result = userDAO.saveUser(user);
		return result;
	}
	
	@Override
	public int saveAdminUser(User user) {
		//관리자 계정 추가할 때 필요한 체크 로직...
		user.setUserType(CommonCode.USER_USERTYPE_ADMIN);
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		//사용자 계정 추가할 때 필요한 체크 로직...
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userDAO.saveUser(user);
		return result;
	}

	@Override
	public List<User> findUserList() {

		List<User> userList = userDAO.findUserList();
		return userList;
	}

	@Override
	public User findUserById(String id) {
		User user = userDAO.findUserById(id);
		return user;
	}

	@Override
	public User checkUserLogin(User user) {
		//매개변수로 들어온 User 객체에 id, pw, userType가 로그인 조건에 맞는지 여부 체크
		//메서드 주요 로직 -> 로그인 처리 성공? 실패?
		
		// id pw 일치하나?
		
// 케이스 1) DB에서 정보를 조회한 후 -> Service Layer 상태에서 비교하는 로직을 수행! ====================================================
		
//		//사용자 정보를 조회해서, id pw 맞는지 확인
//		User loginUser = userDAO.findUserById(user.getId());
//		
//		// if( loginUser != null)
//		if( loginUser != null && loginUser.getPw().equals(user.getPw())
//				&& loginUser.getUserType().equals(user.getUserType()) ) {
//			return loginUser;
//		}
//		// checkUserLogin 메소드 호출 -> return null? id,pw 틀렸다
//		//	return User객체 ? -> 맞다!
//		
//		return null;
		
		/*
		 	return 의미가 담긴 코드 (SUC, FAL, LCK)...
		  	int 숫자 return -> 1:성공 2:id는맞는데 비번이틀림 3:id없음
		  					 4:신고로잠겼다 5:휴면계정 6:..
		 */
// 케이스 2) DB에서 쿼리를 통해, 정상여부 체크 로직 수행! ============================================================================
		// userDAO.checkUserLogin -> sql query 상에서 id, pw, userType 동일한 경우를 체크
		
		User loginUser = userDAO.checkUserLogin(user);
		return loginUser; //조회O: 객체, 조회X: null
	}

	@Override
	public int modifyUserPw(User user) {
		
		int result = userDAO.modifyUserPw(user);
		return result;
	}

	@Override
	public int modifyUserInfo(User user) {
		
		int result = userDAO.modifyUserInfo(user);
		return result;
	}

	@Override
	public List<User> findUserListBySearchCondition(UserSearchCondition userSearchCondition) {
		
		List<User> userList = userDAO.findUserListBySearchCondition(userSearchCondition);
		return userList;
	}

	@Override
	public boolean isDuplicatedId(String id) {
		
		User user = userDAO.findUserById(id);
		if(user == null) { // 해당 아이디 객체가 없다 -> id값 사용안함 -> 중복X
			return false;
		}else{ // 아이디 객체가 있다 -> id값이 pk로 사용되고 있다 -> 중복 O
			return true;
		}
	}
}




























