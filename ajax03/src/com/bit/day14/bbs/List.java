package com.bit.day14.bbs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("application/xml); charset=\"utf-8\"");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("{\"bbs\":[");

		String sql = "SELECT * FROM BBS05 ORDER BY NUM DESC";
		Connection conn = null;
		int cnt = 0;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (cnt++ != 0)
					out.print(",");

				out.println("{");
				out.println("\"num\":\"" + rs.getInt("num") + "\"");
				out.println(",\"name\":\"" + rs.getString("name") + "\"");
				out.println(",\"title\":\"" + rs.getString("title") + "\"");
				out.println(",\"content\":\"" + rs.getString("content") + "\"");
				out.println(",\"ddate\":\"" + rs.getDate("ddate").toString()
						+ "\"");
				out.println("}");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}
}
