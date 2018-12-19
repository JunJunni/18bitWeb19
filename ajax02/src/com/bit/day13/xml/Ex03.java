package com.bit.day13.xml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet {

	//ex03.xml
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id =req.getParameter("id");
		String pw=req.getParameter("pw");
		boolean result=false;
		if(id.equals("admin") && pw.equals("1234")){
			result=true;
		}
		resp.setContentType("application/xml; charset=\"UTF-8\"");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		out.println("<root>");
			out.println("<login>");
			out.println("<result>"+result+"</result>");
			out.println("<id>"+id+"</id>");
			out.println("</login>");
		out.println("</root>");
		out.close();
	}
}
