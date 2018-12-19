package com.bit.day18.comtroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String msg=getInitParameter("msg");
		System.out.println("msg");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
