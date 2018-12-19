package com.bit.day15.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emp01Dao { // Data Access Object
	// db접속한다.
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "scott";
	private final String password = "tiger";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ArrayList<Emp01Dto> selectAll() {// 전체
		// db정보를 담을 자료구조 선택
		ArrayList<Emp01Dto> list = new ArrayList<Emp01Dto>();

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement("select * from emp01");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp01Dto dto = new Emp01Dto();
				// dto에 데이터를 싣자~~
				dto.setSabun(rs.getInt("sabun"));
				dto.setName(rs.getString("name"));
				dto.setDdate(rs.getDate("ddate"));
				dto.setsal(rs.getInt("sal"));
				list.add(dto);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertOne(String name, int sal) {
		String sql = "INSERT INTO EMP01 VALUES (EMP01_SEQ.NEXTVAL,?,SYSDATE,?)";
		int su = 0;
		// db접속한다.
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			su = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}

	public Emp01Dto selectOne(int sabun) {
		String sql = "SELECT * FROM EMP01 WHERE SABUN=?";
		Emp01Dto dto = new Emp01Dto();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sabun);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setSabun(rs.getInt("sabun"));
				dto.setName(rs.getString("name"));
				dto.setDdate(rs.getDate("ddate"));
				dto.setsal(rs.getInt("sal"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;

	}

	public int updateOne(int sabun, String name, int sal) {
		// 수행결과 리턴함수
		int su = 0;
		String sql = "UPDATE EMP01 SET NAME=?,SAL=? WHERE SABUN=?";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, sal);
			pstmt.setInt(3, sabun);
			su = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return su;
	}

}
