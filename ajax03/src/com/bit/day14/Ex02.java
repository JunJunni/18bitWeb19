package com.bit.day14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02 extends HttpServlet {
//�̹����� ����غ��ô�! 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String[] name={"small1.jpg","small2.jpg","small3.jpg","small4.jpg",
				"small5.jpg","small6.jpg"};
		String[] title={"īŰ","�ӽ�Ÿ��","����","��","�׷���","���̺�"};
		
		resp.setContentType("application/json ,charset=\"UTF-8\"");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("{\"imgs\":[");
		for(int i=0; i<name.length; i++){
			if(i!=0)out.print(", ");
			out.println("{\"name\":\""+name[i]+"\",\"title\":\""+title[i]+"\"}");
		}
		
		out.println("]}");
		out.close();
	}
}
