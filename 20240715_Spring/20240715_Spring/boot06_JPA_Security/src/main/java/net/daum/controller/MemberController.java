package net.daum.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.MemberService;
import net.daum.vo.MemberVO;

@Controller
public class MemberController {//사용자 회원관리 컨트
	
	@Autowired
	private MemberService memberService;
	
	//스프링 구조틀을 따라가지만 시큐리티에서 제공하는 것을 주로 이용
	
	@Autowired
	private PasswordEncoder passwordEncoder; //스프링 시큐리티 내장 api를 이용한 비번암호화 자동의존성 주입(DI)
	
	//회원가입폼
	@GetMapping("/member_join")
	public ModelAndView member_join() {
		return new ModelAndView("member_join");
		//생성자 인자값으로 뷰페이지 경로 설정 => WEB-INF/views/member/member_join.jsp
	}

	//아이디 중복검색
	@PostMapping("/member_idcheck")
	public ModelAndView member_idcheck(String id, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");//브라우저에 출력되는 문자와 태그, 언어코딩 타입을 설
		PrintWriter out = response.getWriter(); //출력스트림 out 생성
		
		MemberVO db_id = this.memberService.idCheck(id);
		//DB로부터 아이디에 해당하는회원정보를 검색
		
		int result = -1; //중복되는 아이디가 없는 경우의 반환값
		
		if(db_id != null) {//중복아이디가 있는경우
			result = 1;
		}
		
		out.println(result);//값반환
		
		return null;
	}//member_idcheck()
	
	//회원저장
	@RequestMapping("/member_join_ok")
	public String member_join_ok(MemberVO m) {
		/*
		 * member_join.jsp의 네임파라미터 이름과 MemeberVO빈클래스 변수명이 같으면
		 * MemberVO m에 입력한정보가 저장돼 있다.
		*/
		m.setMem_pwd(passwordEncoder.encode(m.getMem_pwd()));
		//암호화 => 비번저장
		this.memberService.insertMember(m);//회원저장
		/*문제 )
		 * 데이터베이스에 JPA로 회원저장 되게 만들어보자 .
		 * save method 사용.
		 */
		return "redirect:/login"; //회원저장 성공후 redirect로 로그인화면 이동
	}//member_join_ok
}
