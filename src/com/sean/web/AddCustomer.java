package com.sean.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class AddCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService();
		Map<String, String[]> map = request.getParameterMap();
		Customers c = new Customers();
		DateConverter dc = new DateConverter();
		dc.setPattern("yyyy-MM-dd");
		
		try {
			ConvertUtils.register(dc, java.util.Date.class);
			BeanUtils.populate(c, map);
			service.addCustomer(c);
			request.getRequestDispatcher("/finall").forward(request, response);
		} catch (IllegalAccessException | InvocationTargetException | MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
