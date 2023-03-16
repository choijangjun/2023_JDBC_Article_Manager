package com.KoreaIt.example.JAM.session;

import com.KoreaIt.example.JAM.dto.Member;

public class Session {
	
	public static int loginedMemberId;
	public static Member loginedMember;
	
	static {
		loginedMemberId = -1;
	}
	
	public static void login(Member member) {
		loginedMemberId = member.id;
		loginedMember = member;
	}
	
	public static void logout() {
		loginedMemberId = -1;
		loginedMember = null;
	}
	
	public static boolean isLogined() {
		return loginedMemberId != -1;
	}
	
	
	
}	
