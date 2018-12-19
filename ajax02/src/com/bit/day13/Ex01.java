package com.bit.day13;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Ex01 implements Servlet{//다형성을 통해.. 오버라이딩된 함수를 호출...수행가능해짐! 
	ServletConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "bit01class";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		config=arg0;
		System.out.println("Ex01 class init...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) //아우리가 필요한것! 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Class services");
		
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("starving.....");
		out.println("<h1>ㅂㅐ고파죽겠ㄴ ㅔ;//</h1>");
		out.flush();
		out.close();
	}

}
