package com.bit.day15.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.day15.model.Emp01Dao;

public class AddController extends HttpServlet{
// /inser.bit �� ���� �� Ŭ����~ add.bit���� �Ѿ��~~
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//get param
		req.setCharacterEncoding("utf-8");
		System.out.println("����1");
		
		//����� �������� �ڵ�����~ �״ϱ� ��ŵ
		String name=req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("sal"));
		System.out.println("����2");
		
		//dao
		Emp01Dao dao = new Emp01Dao();
		int su=dao.insertOne(name, sal);
		System.out.println("����3");
		
		//list.bit page redirect
		if(su>0)resp.sendRedirect("list.bit?result='success'");
		else resp.sendRedirect("list.bit?result='failure'");
		System.out.println("����4");
	}
}
