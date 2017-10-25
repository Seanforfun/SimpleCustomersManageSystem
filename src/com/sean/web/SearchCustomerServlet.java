package com.sean.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class SearchCustomerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		String searchOption = request.getParameter("select");
		
		if(null != msg && null != searchOption)
		{
			ArrayList<Customers> customers = new ArrayList<>();
			CustomerService service = new CustomerService();
			try {
				customers = service.findSpecificCustomer(msg, searchOption);
				request.setAttribute("customers", customers);
				request.getRequestDispatcher("show/showSpecificCustomers.jsp").forward(request, response);
			} catch (MySqlException e) {
				response.getWriter().write(e.getMessage());
			}
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
