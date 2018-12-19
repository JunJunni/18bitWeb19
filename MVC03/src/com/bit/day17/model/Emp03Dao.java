package com.bit.day17.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bit.day17.util.MyOra;

public class Emp03Dao {

	private PreparedStatement pstmt;
	private ResultSet rs;

	// 리스트
	public ArrayList<Emp03Dto> selectAll() throws SQLException {
		String sql = "SELECT EMPNO,(SELECT NAME FROM USER03 WHERE NUM=UNUM)AS \"NAME\",SUB,CONTENT,DDATE,CNT FROM EMP03";
		ArrayList<Emp03Dto> list = new ArrayList<Emp03Dto>();
		try {
			pstmt = MyOra.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Emp03Dto dto = new Emp03Dto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setName(rs.getString("name"));// 디비에는 없는것, 서브쿼리에서 as 네임으로
													// 받았다.
				dto.setSub(rs.getString("sub"));
				dto.setContent(rs.getString("content"));
				dto.setDdate(rs.getDate("ddate"));
				dto.setCnt(rs.getInt("cnt"));

				list.add(dto);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (MyOra.getConnection() != null)
					MyOra.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// insert
	public void insertOne(String sub, String content, int unum)
			throws SQLException {
		String sql = "INSERT INTO EMP03 VALUES (EMP03_SEQ.NEXTVAL,?,?,?,SYSDATE,0)";
		try {
			pstmt = MyOra.getConnection().prepareStatement(sql);
			pstmt.setInt(1, unum);
			pstmt.setString(2, sub);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} finally { //throw로 익셉션을 던졌기때문에 강제로 finally 사용한다. 
			try {
				if (pstmt != null)
					pstmt.close();
				if (MyOra.getConnection() != null)
					MyOra.getConnection().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
