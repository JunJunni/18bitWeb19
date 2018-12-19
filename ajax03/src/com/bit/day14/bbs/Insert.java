package com.bit.day14.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet{
//insert.bit
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		String content=req.getParameter("content");
		
		String sql="insert into bbs05 values ((select max(num)+1 from bbs05),?,?,?,sysdate)";
	}

}
