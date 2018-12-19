package com.bit.day13.xml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//여러개의 데이터가 있을때! 
public class Ex02 extends HttpServlet {
	// ex02.xml

	String[] names = { "small1.jpg", "small2.jpg", "small3.jpg", "small4.jpg",
			"small5.jpg", "small6.jpg" };

	@Override
	// 데이터의 조작은 아니니 get방식으로 하겠다.
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/xml; charset=\"UTF-8\"");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<imgs>");
		for (int i = 0; i < names.length; i++) {
			out.println("<img>");
				out.println("<name>" + names[i] + "</name>");
				out.println("<path>http://localhost:8080/ajax02/imgs/</path>");
			out.println("</img>");
		}
		out.println("</imgs>");
		out.close();
	}
}
