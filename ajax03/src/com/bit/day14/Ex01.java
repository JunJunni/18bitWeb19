package com.bit.day14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex01 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ex01.json
		/*
		 *{"root":[{
	"id":"admin","name":"包府磊"}
	]} 
	 */
		int num=4321;
		resp.setContentType("application/json; charset=\"UTF-8\""); 
		PrintWriter out = resp.getWriter();
		out.println("{\"root\":[{");
		out.println("\"id\":\"admin\",\"name\":\"包府磊\",\"num\":"+num+"}");
		out.println("]}");
		out.close();
	}
}
