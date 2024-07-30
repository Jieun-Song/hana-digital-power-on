package net.daum.service;

import net.daum.vo.MemberVO;

public interface MemberService {

	MemberVO idCheck(String id);

	void insertMember(MemberVO m);

}
