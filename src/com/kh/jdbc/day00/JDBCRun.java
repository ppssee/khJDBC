package com.kh.jdbc.day00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;


public class JDBCRun {

	public static void main(String[] args) {
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "KH";
			String pw = "kh";
			String sql = "SELECT * FROM EMPLOYEE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection(url, user, pw);
			Statement stmt = conn.createStatement();
			
			ResultSet rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				System.out.println(rset.getString("EMP_NAME"));
			}
			rset.close();
			stmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
