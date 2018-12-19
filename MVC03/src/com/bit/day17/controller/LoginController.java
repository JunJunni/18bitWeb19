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
		//page �ϳ��� �ϳ��� ó���� �ҷ��� ���ǻ��! 
		//jsp�� �ٸ��� session���尴ü�� �������� �ʴ´�. 
		//response (request - �����,�������� ������ �����ִ�.) ���� ���ǰ�ü �޾Ƴ���
		
		HttpSession session = req.getSession();
		if(unum>0){ //�α����� true ���! 
			session.setAttribute("result", true);
			session.setAttribute("id", id);
			session.setAttribute("pw", unum); //���׶��� ����� �����̶��?
		}
		resp.sendRedirect("/MVC03/");
		
	}
}
