package com.sean.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sean.dao.CustomerDao;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;
import com.sean.vo.PageBean;

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

	public PageBean findByPage(int pageNum, int numberPerPage) throws MySqlException {
		int totalNumber = dao.findCustomerNum();
		int totalPage = (int) Math.ceil((double)totalNumber/numberPerPage);
		List<Customers> customers = dao.findByPage(pageNum, numberPerPage);
		PageBean pb = new PageBean();
		pb.setCs(customers);
		pb.setPageNum(pageNum);
		pb.setNumPerPage(numberPerPage);
		pb.setTotalPage(totalPage);
		return pb;
	}

}
