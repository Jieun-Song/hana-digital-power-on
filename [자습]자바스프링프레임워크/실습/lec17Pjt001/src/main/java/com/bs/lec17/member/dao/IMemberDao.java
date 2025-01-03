package com.bs.lec17.member.dao;

import com.bs.lec17.member.Member;

import java.util.Map;

public interface IMemberDao {
	void memberInsert(String memId, String memPw, String memMail, String memPhone1, String memPhone2, String memPhone3);
	Member memberSelect(String memId, String memPw);
	void memberUpdate();
	void memberDelete();

	Map<String, Member> memberDelete(Member member);
}
