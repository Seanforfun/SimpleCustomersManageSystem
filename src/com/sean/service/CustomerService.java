package com.sean.service;

import java.sql.SQLException;
import java.util.ArrayList;
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

	public void deleteCustomer(String id) throws MySqlException {
		dao.deleteCustomerbyId(id);
	}

	public Customers findById(String id) throws MySqlException {
		Customers c = dao.findById(id);
		return c;
	}

	public void modifyCustomerInfo(Customers c) throws MySqlException {
		dao.modifyCustomerInfo(c);
	}

	public void addCustomer(Customers c) throws MySqlException {
		dao.addCustomer(c);
	}

	public void deleteSelectedCustomer(String[] id) throws MySqlException {
		dao.deleteSelectedCustomers(id);
	}

	public ArrayList<Customers> findSpecificCustomer(String msg, String searchOption) throws MySqlException {
		ArrayList<Customers> customers = new ArrayList<>();
		customers = (ArrayList<Customers>) dao.findSpecificCustomer(msg, searchOption);
		return customers;
	}

}
