package com.bit.day16.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day16.model.Emp02Dao;
// /list.bit
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Emp02Dao dao = new Emp02Dao();
		req.setAttribute("list", dao.selectAll()); //exception thorow·Î ¾È´øÁü.... 
		
		
	RequestDispatcher rd=req.getRequestDispatcher("./board/list.jsp");
	rd.forward(req, resp);
	}
}
