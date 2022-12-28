package com.kh.jdbc.day01.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentDAO {

	public List<Student> selectALL() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "student";
		String password = "student";
		String sql = "SELECT * FROM STUDENT_TBL";
		Student student = null;
		List<Student> sList = null;
		
		try {
			// 1. 드라이버 등록 
			Class.forName("oracle.jdbc.driver.OracleDriver");                          // 안외워도됨.
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(url, user, password);
			// 3. 쿼리문 실행준비(Statement 객체 생성)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및 결과 받기
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>();
			
			// 후처리
			while(rset.next()) {
				student = new Student();
				student.setStudentId(rset.getString("STUDENT_ID"));
				student.setStudentName(rset.getString("STUDENT_NAME"));
				student.setStudentPwd(rset.getString("STUDENT_PWD"));
				student.setAge(rset.getInt("AGE"));    					  // int형은 getInt로 시험문제
				student.setEmail(rset.getString("EMAIL"));
				student.setPhone(rset.getString("PHONE"));
				student.setGender(rset.getString("GENDER"));
				student.setAddress(rset.getString("ADDRESS"));
				student.setHobby(rset.getString("HOBBY"));
				student.setEnrollDate(rset.getDate("ENROLL_DATE"));    // Date는 getDate로
				sList.add(student);
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
		
		return sList;
	}
	
	public int insertMember(Student student) {

		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user= "student";
		String password = "student";
		int result = 0;
		
		String sql = "INSERT INTO STUDENT_TBL VALUES("
				+ "'"+student.getStudentId()+"',"
				+ "'"+student.getStudentPwd()+"',"
				+ "'"+student.getStudentName()+"',"
				+ "'"+student.getGender()+"',"
				+     student.getAge()+","
				+ "'"+student.getEmail()+"',"
				+ "'"+student.getPhone()+"',"
				+ "'"+student.getAddress()+"',"
				+ "'"+student.getHobby()+"',"
				+ "SYSDATE)";
		


		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url,user,password);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML!!!!!!!!!!!!!!!!!
			result = stmt.executeUpdate(sql);    //  실패하면 0 , 성공하면 행(row)의 개수가 반환됨.        시험문제
												 //  SELECT쿼리 -> executeQuery -> ResultSet
												 //  INSERT쿼리 -> executeUpdate -> int
												 //     DML(INSERT,UPDATE,DELETE)
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
