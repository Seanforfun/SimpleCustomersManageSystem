package com.sean.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;

public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String Id = request.getParameter("id");
		CustomerService service = new CustomerService();
		response.sendRedirect(request.getContextPath() + "/findall");
		try {
			service.deleteCustomer(Id);
		} catch (MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
