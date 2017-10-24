package com.sean.service;

import java.sql.SQLException;
import java.util.List;

import com.sean.dao.CustomerDao;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class CustomerService {

	private CustomerDao dao = new CustomerDao();

	public List<Customers> findAll() throws MySqlException {
		List<Customers> ret = null;
		ret = dao.findAll();
		return ret;
	}

}
