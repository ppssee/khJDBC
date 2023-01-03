package com.kh.jdbc.day03.member.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.day03.member.model.dao.MemberDAO;
import com.kh.jdbc.day03.member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDao;
	
	public MemberService() {
//		jdbcTemplate = JDBCTemplate.getDriverLoad();
		mDao = new MemberDAO();
	}
	
	public List<Member> selectAll(){
		List<Member> mList = null;
		Connection conn = JDBCTemplate.getConnection();
		mList = mDao.selectAll(conn);
//		jdbcTemplate.close(conn);
		return mList;
	}
	
	public Member selectOneById(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}

	public List<Member> selectOneByName(String memberName) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> mList = mDao.selectAllByName(conn, memberName);
		return mList;
	}

	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDao.insertMember(conn, member);
		if(result > 0 ) {				  	// insert가 제대로 됐다면 커밋
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);	// insert가 실패했다면 롤백
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int modifyMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = mDao.updateMember(conn, member);
		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int removeMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDao.removeMember(conn, memberId);
		if(result > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member loginMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		member = mDao.loginMember(conn, member);
		return member;
	}
}
