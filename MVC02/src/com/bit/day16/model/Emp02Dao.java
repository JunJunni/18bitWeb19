package com.bit.day16.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.day16.model.Emp02Dto;

public class Emp02Dao {
	private final String driver = "oracle.jdbc.OracleDriver";
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "scott";
	private final String password = "tiger";
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private void myConnection() { // db와 연결하기위한 함수!
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 리스트
	public ArrayList<Emp02Dto> selectAll() {
		ArrayList<Emp02Dto> list = new ArrayList<Emp02Dto>();
		String sql = "SELECT * FROM EMP02";
		myConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp02Dto dto = new Emp02Dto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setName(rs.getString("name"));
				dto.setDdate(rs.getDate("ddate"));
				dto.setPay(rs.getInt("pay"));
				dto.setCnt(rs.getInt("cnt"));
				list.add(dto);
			}
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

		return list;
	}

	// 상세
	public Emp02Dto selectOne(int empno) {
		Emp02Dto dto = new Emp02Dto();
		String sql = "SELECT * FROM EMP02 WHERE EMPNO=?";
		myConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setEmpno(rs.getInt("empno"));
				dto.setName(rs.getString("name"));
				dto.setDdate(rs.getDate("ddate"));
				dto.setPay(rs.getInt("pay"));
				dto.setCnt(rs.getInt("cnt"));
			}
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

	// 입력
	public void insertOne(String name, int pay) {
		String sql = "INSERT INTO EMP02 VALUES (EMP02_SEQ.NEXTVAL,?,SYSDATE,?,0)";
		myConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.executeUpdate();
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

	}

	// 수정
	public int updateOne(String name, int pay, int empno) {
		String sql = "UPDATE EMP02 SET NAME=?,PAY=? WHERE EMPNO=?";
		myConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, empno);
			return pstmt.executeUpdate();
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
		return 0;
	}

	// 삭제
	public int delOne(int empno) {
		String sql = "DELETE FROM EMP02 WHERE EMPNO=?";
		myConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);
			return pstmt.executeUpdate();
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
		return 0;
	}
}
