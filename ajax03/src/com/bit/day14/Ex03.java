package com.bit.day14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03 extends HttpServlet{
	// /ex03.bit
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String pw=req.getParameter("pw");
		boolean result=false;
		String name="¼Õ´Ô";
		
		if("admin".equals(id)&&"1234".equals(pw)){
			result=true;
			name="°ü¸®ÀÚ";
		}
		
		resp.setContentType("text/json; charset=\"utf-8\"");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("{\"login\":[");
		out.println("{\"result\":"+result+",\"name\":\""+name+"\"}");
		out.println("]}");
		
		out.close();
	}

}
