package com.sean.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;

public class DeleteSelectCustomer extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String[] id = request.getParameterValues("ck");
		CustomerService service = new CustomerService();
		try {
			service.deleteSelectedCustomer(id);
			request.getRequestDispatcher("/findall").forward(request, response);
		} catch (MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
