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
		
		//��� ������ ���� �ʰ� �ӽ÷� id�� pw�� �־� �׽�Ʈ 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id:"+id+",pw:"+pw);
		String name = "admin";
		boolean result = false;
		
		if(id.equals("admin") && pw.equals("1234")){ //��й�ȣ�� ���̵� �˻�
			result = true; //�˻簡 �´ٸ� true
			HttpSession session = request.getSession(); //������ �䱸�ؼ�
			session.setAttribute("name", name); //�Ӽ��� ������� �̸��� �ٲ۴�. 
		}
		
		//json�� ����
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
			out.print("null"); //ID �� PW �� ��ġ���� ������ null �ֿܼ� ����
		}
		out.print("}");
		out.close();
	}



}
