package com.kh.jdbc.day01.student.controller;

import java.util.List;

import com.kh.jdbc.day01.student.model.dao.StudentDAO;
import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentController {

	/**
	 * 학생 전체 목록 조회
	 * @return List<Student>
	 */
	public List<Student> printAll() {			// 1. 전체조회
		StudentDAO sDao = new StudentDAO();
		
		List<Student> student = sDao.selectALL();
		return student;
	}
	
	/**
	 * 학생 아이디로 조회
	 * @param studentId
	 * @return Student
	 */
	public Student printOneById(String studentId) {			// 2. id로 조회
		StudentDAO sDao = new StudentDAO();
		Student student = sDao.selectOneById(studentId);
		
		return student;
	}
	
	/**
	 * 학생 이름으로 조회
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> printAllByName(String studentName) {		// 3. 이름으로 조회
		StudentDAO sDao = new StudentDAO();
		List<Student> sList = sDao.selectAllByName(studentName);
		return sList;
	}

	
	/**
	 * 회원가입
	 * @param student
	 * @return int
	 */
	public int registerStudent(Student student) {		// 4. 회원가입
		StudentDAO sDao = new StudentDAO();
		
		
		int result = sDao.insertMember(student);
		return result;
	}
	
	/**
	 * 회원탈퇴
	 * @param studentId
	 * @return int
	 */
	public int removeStudent(String studentId) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.deleteMember(studentId);
		return result;
		
	}
	/**
	 * 회원정보 수정
	 * @param student
	 * @return int
	 */
	public int modifyStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.updateStudent(student);
		
		return result;
	}
	
}

