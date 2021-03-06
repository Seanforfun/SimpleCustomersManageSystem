package com.sean.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sean.utils.DataSourceUtils;
import com.sean.utils.IdUtils;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class CustomerDao {

	public List<Customers> findAll() throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer";
		List<Customers> list = null;
		try {
			list = runner.query(sql, new BeanListHandler<Customers>(
					Customers.class));
		} catch (SQLException e) {
			throw new MySqlException("Find all exception. Please check");
		}
		return list;
	}

	public void deleteCustomerbyId(String id) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from customer where id = ?";
		try {
			int ret = runner.update(sql, id);
		} catch (SQLException e) {
			throw new MySqlException("delete customer problem. Please Check.");
		}
	}

	public Customers findById(String id) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer where id = ?";
		Customers c = null;
		try {
			c = runner.query(sql, new BeanHandler<Customers>(Customers.class),
					id);
		} catch (SQLException e) {
			throw new MySqlException("Find by Id Exception, please check.");
		}
		return c;
	}

	public void modifyCustomerInfo(Customers c) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update customer set name=?, gender=?, birthday=?, cellphone=?, email=?, preference=?, type=?, description=? where id = ?";
		try {
			runner.update(sql, c.getName(), c.getGender(), c.getBirthday(),
					c.getCellphone(), c.getEmail(), c.getPreference(),
					c.getType(), c.getDescription(), c.getId());
		} catch (SQLException e) {
			throw new MySqlException("Update exception, Please Check.");
		}
	}

	public void addCustomer(Customers c) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
		try {
			runner.update(sql, IdUtils.getUUID(), c.getName(), c.getGender(),
					c.getBirthday(), c.getCellphone(), c.getEmail(),
					c.getPreference(), c.getType(), c.getDescription());
		} catch (SQLException e) {
			throw new MySqlException("Add Exception, please check.");
		}
	}

	public void deleteSelectedCustomers(String[] id) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from customer where id = ?";
		Object[][] sql1 = new Object[id.length][1];

		for (int i = 0; i < id.length; i++) {
			sql1[i][0] = id[i];
		}

		try {
			runner.batch(sql, sql1);
		} catch (SQLException e) {
			throw new MySqlException(
					"Delete seleted customer exception. Please Check");
		}
	}

	public List<Customers> findSpecificCustomer(String msg, String searchOption) throws MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer where " + searchOption + " like ?";
		List<Customers> customers = null;
		try {
			customers = runner.query(sql, new BeanListHandler<Customers>(
					Customers.class), "%" + msg + "%");
		} catch (SQLException e) {
			throw new MySqlException(
					"Find Specific Customer Exception, pLease check.");
		}
		return customers;
	}

	public List<Customers> findByPage(int pageNum, int numberPerPage) throws  MySqlException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from customer limit ?,?";
		List<Customers> customers = null;
		try {
			customers = runner.query(sql, new BeanListHandler<Customers>(Customers.class),
					(pageNum - 1) * numberPerPage, numberPerPage);
		} catch (SQLException e) {
			throw new MySqlException("Find by Page Exception, Please check.");
		}
		return customers;
	}

	public int findCustomerNum() throws MySqlException {
		String sql = "select count(*) from customer";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		long num = 0;
		try {
			num = (long) runner.query(sql, new ScalarHandler());
		} catch (SQLException e) {
			throw new MySqlException("findCustomerNum exception, Please check");
		}
		return (int)num;
	}

}
