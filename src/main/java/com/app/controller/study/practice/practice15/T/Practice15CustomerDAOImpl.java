package com.app.controller.study.practice.practice15.T;

import org.springframework.stereotype.Repository;

@Repository
public class Practice15CustomerDAOImpl implements Practice15CustomerDAO {

	@Override
	public int saveCustomer(Practice15Customer practice15Customer) {
		//DB에 저장하는 과정...
		System.out.println("[DAO] registerCustomer");
		return 0;
	}
	
 
}
