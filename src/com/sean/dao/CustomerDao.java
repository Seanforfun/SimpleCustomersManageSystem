package com.sean.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sean.utils.DataSourceUtils;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class CustomerDao {

	public List<Customers> findAll() throws MySqlException{
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer";
		List<Customers> list = null;
		try {
			list = runner.query(sql,
					new BeanListHandler<Customers>(Customers.class));
		} catch (SQLException e) {
			throw new MySqlException("Find all exception. Please check");
		}
		return list;
	}

}
