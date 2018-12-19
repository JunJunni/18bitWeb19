package com.bit.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05 extends HttpServlet {
	// ex05.xml
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("application/xml); charset=\"utf-8\"");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		
		
		
		String addr = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
		URL url = new URL(addr);
		URLConnection conn = url.openConnection();
		try (InputStream is = conn.getInputStream()) { // 바이트스트림 -> 문자열 스트림으로
														// 변환하자
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			BufferedReader br = new BufferedReader(isr);

			String msg = null;
			while ((msg = br.readLine()) != null) {
				out.println(msg);
			}
		}
		out.close();
	}

}
