package com.bit.day15.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day15.model.Emp01Dao;
import com.bit.day15.model.Emp01Dto;

public class ListController extends HttpServlet {
//  주소: /list.bit
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//화면 위임전 데이터 전송
		
		Emp01Dao dao = new Emp01Dao();
		ArrayList<Emp01Dto> list = dao.selectAll();
		
		//request scope 
		req.setAttribute("alist", list);
		
		
		//즉 MVC2의 화면 위임 
	RequestDispatcher rd=req.getRequestDispatcher("list.jsp"); //뷰로 사용할 page이름
	rd.forward(req, resp);//이를 이용해서 포워딩한다. 모델에서 보내주는 이 둘을 뷰에서도 쓸 수 있게
	}
}
