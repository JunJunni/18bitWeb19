package com.bit.day15.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day15.model.Emp01Dao;
import com.bit.day15.model.Emp01Dto;

public class OneController extends HttpServlet{
	// /detail.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//param
		int sabun =Integer.parseInt(req.getParameter("idx"));
		
		//dao
		Emp01Dao dao = new Emp01Dao();
		Emp01Dto dto = dao.selectOne(sabun);
		
		//setAttr
		
		req.setAttribute("bean", dto);
		
		//forward
		RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
		rd.forward(req, resp);
	}

}
