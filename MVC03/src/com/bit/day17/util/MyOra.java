package com.bit.day17.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyOra { //connection ��ü�� �����ֵ�, �̱�������~
	private static Connection conn;
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "scott";
	private static String password = "tiger";

	private MyOra(){//��ü���� ��ü�� ���ϵ��� �����ڸ� private 
		
	}
	
	public static Connection getConnection() throws SQLException{ 
		if(conn==null || conn.isClosed()){//�̶��� ��ü�� ����
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
