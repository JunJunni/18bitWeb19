package com.bit.day18.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Emp03Dao{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection conn;
	
	public ArrayList<Emp03Dto> selectAll()throws SQLException{
		ArrayList<Emp03Dto> list = new ArrayList<Emp03Dto>();
		String sql="SELECT * FROM EMP03 ORDER BY NUM DESC";
		Connection conn = null;

		try {
			InitialContext init = new InitialContext();
			Context context = (Context)init.lookup("java:/comp/env");
			DataSource source=(DataSource) context.lookup("jdbc/oracle");
			conn=source.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Emp03Dto bean = new Emp03Dto();
				bean.setNum(rs.getInt("num"));
				bean.setUnum(rs.getInt("unum"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setDdate(rs.getDate("ddate"));
				bean.setCnt(rs.getInt("cnt"));
				list.add(bean);
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return list;
	}
	public Emp03Dto selectOne(int num) throws SQLException{
		Emp03Dto bean=new Emp03Dto();
		String sql="SELECT * FROM EMP03 WHERE NUM=?";
		
		try {
			InitialContext init = new InitialContext();
			DataSource dataSource=(DataSource) init.lookup("java:/comp/env/jdbc/oracle");
			conn=dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()){
				bean.setNum(rs.getInt("num"));
				bean.setUnum(rs.getInt("unum"));
				bean.setSub(rs.getString("sub"));
				bean.setContent(rs.getString("content"));
				bean.setDdate(rs.getDate("ddate"));
				bean.setCnt(rs.getInt("cnt"));
			}
		}finally{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		
		return bean;
	}
	
}
