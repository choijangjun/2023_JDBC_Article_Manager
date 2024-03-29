package com.KoreaIt.example.JAM.service;

import java.sql.Connection;
import java.util.Map;

import com.KoreaIt.example.JAM.dao.MemberDao;
import com.KoreaIt.example.JAM.dto.Member;

public class MemberService {

	private MemberDao memberDao;

	public MemberService(Connection conn) {
		this.memberDao = new MemberDao(conn);
	}

	public boolean isLoginIdDup(String loginId) {
		return memberDao.isLoginIdDup(loginId);
	}

	public void doJoin(String loginId, String loginPw, String name) {
		memberDao.doJoin(loginId, loginPw, name);
	}


	public Member getMemberByLoginId(String loginId) {
		Map<String, Object> memberMap = memberDao.getMemberByLoginId(loginId);
			
		if(memberMap.isEmpty() ) {
			return null;
		}
		
		return new Member(memberMap);
	}

}