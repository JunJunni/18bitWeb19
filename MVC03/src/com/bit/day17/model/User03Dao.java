package com.bit.day17.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bit.day17.util.MyOra;

public class User03Dao {
	private PreparedStatement pstmt;
	private ResultSet rs;
	// insert
	public void addUser(String id, String pw, String name) throws SQLException {
		String sql = "INSERT INTO USER03 VALUES(USER03_SEQ.NEXTVAL,?,?,?)";

		try (Connection conn = MyOra.getConnection()) {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.executeUpdate();
		}
	}

	// Login check
	public int loginCheck(String id, String pw) throws SQLException {
		String sql = "SELECT NUM FROM USER03 WHERE ID=? AND PW=?";
		try (Connection conn = MyOra.getConnection()) {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt("num");
			}
		}
		return 0; //login fail = index number is '0'

	}
}
