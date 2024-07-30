package net.daum.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private MemberRepository memberRepo;

	@Override
	public MemberVO idCheck(String id) {
		
		System.out.println("\n ==========> 아이디 중복검색(JPA)");
		Optional<MemberVO> result = this.memberRepo.findById(id);//아이디에 해당하는 회원정보 검색
		MemberVO member;
		
		if(result.isPresent()) {//해당회원이 있다면
			member = result.get();//엔티티빈 타입을 구함
		}else {//회원정보가 없는 경우
			member = null;
		}
		return null;
	}//아이디 중복검색

	@Override
	public void insertMember(MemberVO m) {
//		m.setId(mem_id);
		this.memberRepo.save(m);
	}//회원저장
	
	
	
}
