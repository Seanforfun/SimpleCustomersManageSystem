package com.sean.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class CustomerFindallServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		CustomerService service = new CustomerService();
		try {
			List<Customers> customers = service.findAll();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("/show/showCustomers.jsp").forward(request, response);
			return;
		} catch (MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
