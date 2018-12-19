package com.bit.day17.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOra { //connection 객체를 던져주되, 싱글톤패턴~
	private static Connection conn;
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "scott";
	private static String password = "tiger";

	private MyOra(){//객체생성 자체를 못하도록 생성자를 private 
		
	}
	
	public static Connection getConnection() throws SQLException{ 
		if(conn==null || conn.isClosed()){//이때는 객체를 생생
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
