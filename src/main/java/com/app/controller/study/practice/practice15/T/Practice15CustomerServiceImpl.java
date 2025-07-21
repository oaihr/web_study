package com.app.controller.study.practice.practice15.T;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Practice15CustomerServiceImpl implements Practice15CustomerService {
	
	@Autowired
	Practice15CustomerDAO practice15CustomerDAO;
	
	public int saveCustomer(Practice15Customer practice15Customer) {
		System.out.println("[Service] registerCustomer");
		int result = practice15CustomerDAO.saveCustomer(practice15Customer);
		return result;
	}
}
