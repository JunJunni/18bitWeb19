package com.bit.day18.comtroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day18.model.Emp03Dao;
import com.bit.day18.model.Emp03Dto;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/bbs/list.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Emp03Dao dao = new Emp03Dao();
		
		try {
			ArrayList<Emp03Dto> list = dao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("../list.jsp").forward(request, response);
	}


}
