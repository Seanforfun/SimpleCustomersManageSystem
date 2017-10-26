package com.sean.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.service.CustomerService;
import com.sean.utils.MySqlException;
import com.sean.vo.Customers;
import com.sean.vo.PageBean;

public class FindAllPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pageNum = 1;
		String _pageNum = (String) request.getParameter("pageNum");
		
		if(null != _pageNum)
		{
			pageNum = Integer.parseInt(_pageNum);
		}
		
		int numberPerPage = 2;
		
		String _numberPerPage = request.getParameter("numPerPage");
		
		if(null != _numberPerPage)
		{
			numberPerPage = Integer.parseInt(_numberPerPage);
		}
		
		CustomerService service = new CustomerService();
		try {
			PageBean pb = service.findByPage(pageNum, numberPerPage);
			request.setAttribute("pb", pb);
			request.getRequestDispatcher("/show/showByPage.jsp").forward(
					request, response);
		} catch (MySqlException e) {
			response.getWriter().write(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
