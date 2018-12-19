package com.bit.day17.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.day17.model.Emp03Dao;

public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("result") == null) {
			// 로그인 안되어 있을때
			resp.sendRedirect("login.do");

		} else if (!(boolean) session.getAttribute("result")) {
			// 로그인 안되어 있을때
			resp.sendRedirect("login.do");
		} else {
			// 로그인 되어있을때
			Emp03Dao dao = new Emp03Dao();
			try {
				req.setAttribute("alist", dao.selectAll());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // exception throw로 안던짐....

			req.getRequestDispatcher("/bbs/list.jsp").forward(req, resp);
		}
	}

}
