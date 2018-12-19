package com.bit.day18.comtroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginContoller
 */
@WebServlet("/login.json")
public class LoginContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//디비 연결을 하지 않고 임시로 id와 pw를 주어 테스트 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id:"+id+",pw:"+pw);
		String name = "admin";
		boolean result = false;
		
		if(id.equals("admin") && pw.equals("1234")){ //비밀번호와 아이디 검사
			result = true; //검사가 맞다면 true
			HttpSession session = request.getSession(); //세션을 요구해서
			session.setAttribute("name", name); //속성을 사용자의 이름을 바꾼다. 
		}
		
		//json문 연결
		response.setContentType("application/json; charset=\"utf-8\"");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("{\"root\":");
		if(result){
			out.print("[{");
			out.print("\"id\":\""+id+"\"");
			out.print(",\"name\":\""+name+"\"");
			out.print("}]");
		}
		else{
			out.print("null"); //ID 와 PW 가 일치하지 않으면 null 콘솔에 찍어봄다
		}
		out.print("}");
		out.close();
	}



}
