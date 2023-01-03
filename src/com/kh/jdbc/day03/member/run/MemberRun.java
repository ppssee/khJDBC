package com.kh.jdbc.day03.member.run;

import java.util.List;

import com.kh.jdbc.day03.member.controller.MemberController;
import com.kh.jdbc.day03.member.model.vo.Member;
import com.kh.jdbc.day03.member.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		List<Member> mList = null;
		Member member = null;
		Member loginMember = null;
		int result = 0;
		String memberId ="";
		String memberName ="";
		gone :
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 0 : break gone;
			case 1 : 		// 1. 회원 정보 조회
				mList = mCon.printAll();
				if(mList.size()>0) {
					mView.showAll(mList);
				} else {
					mView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2 : 		// 2. 회원 아이디로조회  
				memberId = mView.inputMemberId("검색");
				member = mCon.printOneById(memberId);
				mView.showOne(member);
				break;
			case 3 : 		// 3. 회원 이름으로조회 
				memberName = mView.inputMemberName("검색");
				mList = mCon.printOneByName(memberName);
				mView.showAll(mList);
				break;
			case 4 : 		// 4. 회원 가입
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.displaySuccess("가입 성공");
				} else {
					mView.displayError("회원가입 실패");
				}
				break;
			case 5 : 		// 5. 회원 정보 수정 
				memberId = mView.inputMemberId("수정");
				member = mCon.printOneById(memberId);
				if(member != null) {
					member = mView.modifyMember(member);
					mCon.modifyMember(member);
				} else {
					mView.displayError("일치하는 회원 정보가 없습니다.");
				}
				break;
			case 6 : 		// 6. 회원 탈퇴 
				memberId = mView.inputMemberId("삭제");
				result = mCon.removeMember(memberId);
				if(result > 0) {
					mView.displaySuccess("삭제 성공");
				} else {
					mView.displayError("회원삭제 실패");
				}
				break;
			case 7 :  		// 7. 로그인	
				member = mView.loginMember();
				loginMember = mCon.loginMember(member);
				if(loginMember != null) {
					mView.displaySuccess("로그인 성공");
				} else {
					mView.displayError("로그인 실패");
				}
			}
		}
	}

}

