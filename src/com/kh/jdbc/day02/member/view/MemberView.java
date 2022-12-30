package com.kh.jdbc.day02.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.student.model.vo.Student;
import com.kh.jdbc.day02.member.model.vo.Member;

public class MemberView {

	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === === 회원관리 프로그램 === === ===");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 아이디로조회");
		System.out.println("3. 회원 이름으로조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정 ");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 회원 로그인");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택: ");
		int choice = sc.nextInt();
		return choice;
	}

	public void printMessage(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	public void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}

	public void showOne(Member member) {       // 2. Id로 조회
		System.out.println("아이디 : " + member.getMemberId());
		System.out.println("비밀번호 : " + member.getMemberPwd());
		System.out.println("이름 : " + member.getMemberName());
		System.out.println("성별 : " + member.getMemberGender());
		System.out.println("나이 : " + member.getMemberAge());
		System.out.println("이메일 : " + member.getMemberEmail());
		System.out.println("전화번호 : " + member.getMemberPhone());
		System.out.println("주소 : " + member.getMemberAddress());
		System.out.println("취미 : " + member.getMemberHobby());
		System.out.println("가입날짜 : " + member.getEnrollDate());	
	}

	public void showAll(List<Member> members) {
		System.out.println("=== === 학생 전체 목록 조회 === ===");
		
		for(Member sOne : members) {
			System.out.print("아이디 : " + sOne.getMemberId());
			System.out.print(", 비밀번호 : " + sOne.getMemberPwd());
			System.out.print(", 이름 : " + sOne.getMemberName());
			System.out.print(", 성별 : " + sOne.getMemberGender());
			System.out.print(", 나이 : " + sOne.getMemberAge());
			System.out.print(", 이메일 : " + sOne.getMemberEmail());
			System.out.print(", 전화번호 : " + sOne.getMemberPhone());
			System.out.print(", 주소 : " + sOne.getMemberAddress());
			System.out.print(", 취미 : " + sOne.getMemberHobby());
			System.out.println("가입날짜 : " + sOne.getEnrollDate());
		}
		
	}

	

	public Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디: ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		
		System.out.print("이름 : ");
		String memberName = sc.next();
		
		System.out.print("성별 : ");
		String memberGender = sc.next();
		
		System.out.print("나이 : ");
		int memberAge = sc.nextInt();
		
		System.out.print("이메일 : ");
		String memberEmail = sc.next();
		
		System.out.print("전화번호 : ");
		String memberPhone = sc.next();
		
		System.out.print("주소 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();
		
		System.out.print("취미(,)로 구분 : ");
		String memberHobby = sc.next();
		
		Member member = new Member(memberId, memberPwd, memberName, memberGender, memberAge, memberEmail, memberPhone, memberAddress, memberHobby, null);
		return member;
	}

	public String inputMemberId(String string) {
		Scanner sc = new Scanner(System.in);
		System.out.print(string + "할 아이디 입력 : ");
		String id = sc.next();
		return id;
	}
	
	public String inputMemberName(String string) {
		Scanner sc = new Scanner(System.in);
		System.out.print(string + "할 이름 입력 : ");
		String name = sc.next();
		return name;
	}

	public Member modifyMember(Member member) {
		Scanner sc = new Scanner(System.in);

		System.out.print("수정할 비밀번호 입력 : ");
		String memberPwd = sc.next();

		System.out.print("수정할 이메일 입력 : ");
		String memberemail = sc.next();

		System.out.print("수정할 전화번호 입력 : ");
		String memberPhone = sc.next();

		System.out.print("수정할 주소 입력 : ");
		sc.nextLine();
		String memberAddress = sc.nextLine();

		System.out.print("수정할 취미 입력 : ");
		String memberHobby = sc.next();

		member.setMemberPwd(memberPwd);
		member.setMemberEmail(memberemail);
		member.setMemberPhone(memberPhone);
		member.setMemberAddress(memberAddress);
		member.setMemberHobby(memberHobby);

		return member;
	}

	public Member loginMember() {
		Scanner sc = new Scanner(System.in);
		System.out.print("  아이디: ");
		String memberId = sc.next();
		System.out.print("비밀번호: ");
		String memberPwd = sc.next();
		Member member = new Member(memberId, memberPwd);
		return member;
	}
}
