package net.daum.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import net.daum.dao.MemberRepository;

@Service
@Log
public class ZerockUsersService implements UserDetailsService {

	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private HttpServletRequest request;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 회원 아이디를 이용해 UserDetails객체 반환
		System.out.println("\n ==========> UserDetailsService로 접근");
		
		return
				this.memberRepo.findById(username)
				.filter(member -> member != null) //아이디에 해당하는 회원정보가 있다면
				.map(member -> new ZerockSecurityUser(member, request)).get();
		//검색된 회원정보(권한정보)를 Zerock
	}

}
