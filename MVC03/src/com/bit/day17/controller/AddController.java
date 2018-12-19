package com.bit.day17.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day17.model.Emp03Dao;

public class AddController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path=getInitParameter("path");
		String name=this.getInitParameter("name");
		req.getRequestDispatcher(path+name).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String sub = req.getParameter("sub");
		String content=req.getParameter("content");
		//일단 임의로 하는것임
		int unum=3;
		
		//위의 값들을 가지고 db에 입력할것
		Emp03Dao dao = new Emp03Dao();
		
		try {
			dao.insertOne(sub,content,unum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//끝나고 나면 list페이지로 넘어가야할것.. 백엔드에서 해야하기때문에 forward/redirect 중 redirect 선택!
		resp.sendRedirect("list.do");
	}
}
