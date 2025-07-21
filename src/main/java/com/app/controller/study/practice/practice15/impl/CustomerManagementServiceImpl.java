package com.app.controller.study.practice.practice15.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.controller.study.practice.practice15.CustomerDAO;
import com.app.controller.study.practice.practice15.CustomerManagementService;
import com.app.controller.study.practice.practice15.dto.Customer;

@Service
public class CustomerManagementServiceImpl implements CustomerManagementService{
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<Customer> findCustomerList() {
		// TODO Auto-generated method stub
		List<Customer> customerList = customerDAO.findCustomerList();
		System.out.println("[Service]");
		return customerList;
	}

	
	
	
}
