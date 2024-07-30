package net.daum.dao;

import net.daum.vo.MemberVO;

public interface MemberDAO {

	MemberVO idCheck(String id);

	void insertMember(MemberVO m);
	
}
