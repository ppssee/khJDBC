package com.kh.jdbc.day02.member.controller;

import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.dao.StudentDAO;
import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day02.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberController {

	/**
	 * 멤버 전체 목록 조회
	 * @return List<Student>
	 */
	public List<Member> printAll() {			// 1. 전체조회
		MemberDAO mDao = new MemberDAO();
		
		List<Member> members = mDao.selectALL();
		return members;
	}

	public int registerMember(Member member) {	// 4. 회원가입
		MemberDAO mDao = new MemberDAO();
		int result = mDao.insertMember(member);
		return result;
	}

	public Member printOneById(String memberId) {
		MemberDAO mDao = new MemberDAO();
		Member member = mDao.selectOneById(memberId);
		return member;
	}

	public List<Member> printAllByName(String memberName) {
		MemberDAO mDao = new MemberDAO();
		List<Member> mList = new ArrayList<Member>();
		
		mList = mDao.selectAllByName(memberName);
		return mList;
		
	}

	public int modifyMember(Member member) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.updateMember(member);
		return result;
	}

	public int removeMember(String memberId) {
		MemberDAO mDao = new MemberDAO();
		int result = mDao.deleteMember(memberId);
		return result;
	}
}
