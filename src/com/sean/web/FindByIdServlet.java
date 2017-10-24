package com.sean.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;

public class FindByIdServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CustomerService service = new CustomerService();
		try {
			Customers c = service.findById(id);
			request.setAttribute("customer", c);
			request.getRequestDispatcher("/show/showCustomer.jsp").forward(
					request, response);
		} catch (MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
