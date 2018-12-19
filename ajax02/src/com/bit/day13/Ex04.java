package com.bit.day13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex04 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		res.setContentType("text/html; charset=\"UTF-8\"");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = \"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println("서블릿을 이용한 웹 페이지");
		out.println("</h1>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
