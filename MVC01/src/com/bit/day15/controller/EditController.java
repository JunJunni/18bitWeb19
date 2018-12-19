package com.bit.day15.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day15.model.Emp01Dao;

public class EditController extends HttpServlet{
// update.bit
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//param
		req.setCharacterEncoding("utf-8");
		int sabun = Integer.parseInt(req.getParameter("sabun"));
		String name = req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("sal"));
		//dao
		Emp01Dao dao = new Emp01Dao();
		int result = dao.updateOne(sabun, name, sal);
		
		if(result>0){
			resp.sendRedirect("detail.bit?idx="+sabun);
		}else{
			resp.sendRedirect("edit.bit?idx="+sabun);
		}
		
	}
}
