package com.app.controller.study.practice.practice15.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.controller.study.practice.practice15.dto.Customer;

@Repository
public class CustomerDAOImpl implements com.app.controller.study.practice.practice15.CustomerDAO{

	@Override
	public List<Customer> findCustomerList() {
		// TODO Auto-generated method stub
		System.out.println("[DAO]");
		return null;
	}

}
