package com.bit.day13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06 extends Ex05 {
	// /ex06.html
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html); charset=\"UTF-8\"");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = \"UTF-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>");
		out.println("환영 welcom");
		out.println("</h1>");
		out.println("<form action=\"ex07.html\" method=\"post\">");
		out.println("id<input type=\"text\" name=\"id\"/>");
		out.println("<button>전달</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
