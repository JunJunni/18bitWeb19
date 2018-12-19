package com.bit.day17.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.day17.model.User03Dao;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getRequestDispatcher("/login/loginForm.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id=req.getParameter("id");
		String pw = req.getParameter("pw");
		
		User03Dao dao = new User03Dao();
		int unum =0;
		try {
			unum = dao.loginCheck(id, pw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//session 
		//page 하나당 하나의 처리를 할려면 세션사용! 
		//jsp와 다르게 session내장객체가 존재하지 않는다. 
		//response (request - 사용자,브라우저의 정보를 갖고있다.) 따라서 세션객체 받아낸다
		
		HttpSession session = req.getSession();
		if(unum>0){ //로그인이 true 라면! 
			session.setAttribute("result", true);
			session.setAttribute("id", id);
			session.setAttribute("pw", unum); //오잉또잉 비번이 유넘이라니?
		}
		resp.sendRedirect("/MVC03/");
		
	}
}
