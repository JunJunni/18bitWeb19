package com.bit.day18.comtroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.day18.model.Emp03Dao;

/**
 * Servlet implementation class DetailController
 */
@WebServlet("/bbs/detail.do")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("name")==null){ //즉 로그인이 되어있지 않은 상태라면 
			request.getRequestDispatcher("../login.jsp").forward(request,response); //로그인페이지를 보여준다. 
		}else{
			int empno=Integer.parseInt(request.getParameter("idx"));
			Emp03Dao dao = new Emp03Dao();
			
			try {
				request.setAttribute("bean", dao.selectOne(empno));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("../detail.jsp").forward(request, response);
		}
	}

}
