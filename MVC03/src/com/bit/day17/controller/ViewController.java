package com.bit.day17.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String name=req.getRequestURI().replace("/MVC03/", "").replace(".do", "");
	req.getRequestDispatcher(name+".jsp").forward(req, resp);
}
}
