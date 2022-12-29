package com.kh.jdbc.day02.member.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day02.member.controller.MemberController;
import com.kh.jdbc.day02.member.model.vo.Member;
import com.kh.jdbc.day02.member.view.MemberView;

public class MemberRun {
	public static void main(String[] args) {
		MemberView mView = new MemberView();
		MemberController mCon = new MemberController();
		List<Member> mList = null;
		Member member = null;
		int result = 0;
		String memberId = "";
		String memberName = "";
		
		goodbye :
		while(true) {
			int choice = mView.mainMenu();
			switch(choice) {
			case 0 : break goodbye;
			case 1 :		// 1. 회원 전체 조회 
				mList = mCon.printAll();
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				}
				else {
					mView.displayError("데이터가 존재하지 않습니다.");
				}
				break;
			case 2 :		// 2. 회원 아이디로조회 
				memberId = mView.inputMemberId("검색");
				member = mCon.printOneById(memberId);
				if(member != null) {
					mView.showOne(member);
				} else {
					mView.displayError("일치하는 데이터가 없습니다");
				}
				break;
			case 3 :		// 3. 회원 이름으로조회 
				memberName = mView.inputMemberName("검색");
				mList = mCon.printAllByName(memberName);
				// sList는 항상 Null이 아니므로 비어 있는지 아닌지 확인해야함.
				if(!mList.isEmpty()) {
					mView.showAll(mList);
				} else {
					mView.displayError("일치하는 데이터가 없습니다.");
				}
				
				
				break;
			case 4 :		// 4. 회원 가입 
				member = mView.inputMember();
				result = mCon.registerMember(member);
				if(result > 0) {
					mView.displaySuccess("가입이 완료되었습니다.");
				} else {
					mView.displayError("가입 실패하였습니다.");
				}
				
				break;
			case 5 :		// 5. 회원 정보 수정 
				memberId = mView.inputMemberId("수정");
				member = mCon.printOneById(memberId);
				if(member != null) {
					member = mView.modifyMember(member);
					result = mCon.modifyMember(member);
					if(result > 0) {
						mView.displaySuccess("수정이 성공했습니다.");
					} else {
						mView.displayError("수정이 실패하였습니다.");
					}
				} else {
					mView.displayError("일치하는 학생이 없습니다.");
				}
				break;
			case 6 :		// 6. 회원 탈퇴 
				memberId = mView.inputMemberId("검색");
				result = mCon.removeMember(memberId);
				if( result > 0) {
					mView.displaySuccess("탈퇴 완료.");
				} else {
					mView.displayError("탈퇴 실패.");
				}
				break;
			default : 
				mView.printMessage("잘못입력 1~6 사이 수 입력");
				break;
			}
		}
	}
}
