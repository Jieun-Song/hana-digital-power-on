package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.MemberVO;

public interface MemberRepository extends JpaRepository<MemberVO, String>{
	
	@Query(value = "SELECT m.uid2, count(fname) FROM tbl_members6 m LEFT OUTER JOIN tbl_profile3 p "
			+ "on m.uid2 = p.member_uid2 WHERE m.uid2 = ?1 GROUP BY m.uid", nativeQuery = true)
	//NativeQuery문은 말 그대로 데이터베이스 sql문을 그대로 사용하겠다는 뜻이다.
	//복잡한 쿼리 작성에 유리하다.
	//이런 경우는 JPA를 사용하는 목적에서 약간 벗어난다.
	//단방향 fetch join문이다.
	public List<Object[]> getMemberVOWithProfileCount(String id);
	
	@Query(value = "SELECT m.uid2, m.upw, m.uname, p.current2, p.fname FROM tbl_members6 m"
			+ " LEFT OUTER JOIN tbl_profile3 ON m.uid2 = p.member_uid2 "
			+ "WHERE m.uid2 = ?1 AND p.current2 = 1", nativeQuery = true)
	public List<Object[]> getMemberVOWithProfile(String uid);
	//아이디에 대한 회원정보와 현재 사용중인 프로필 사진 정보 =? Fetch 조인문 
	
}
