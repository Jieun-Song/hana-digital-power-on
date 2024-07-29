package net.daum.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity //@EnableWebSecurity를 추가함으로서 스프링에서 웹 시큐리티로 인식하게 된다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//스프링 웹 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속받는다.
	
	@Autowired
	DataSource dataSource; //DBCP 커넥션 풀 관리 DataSource를 통한 SQL문 처리
	
	@Autowired
	ZerockUsersService zerockUsersService;
	
	@Bean //비번 암호
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}//PasswordEncoder 빈등록하고 다른 클래스에서는 @Autowired 자동의존성 주입해야한다
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		//HttpSecurity는 웹과 관련된 다양한 보안설정을 할 수 있다.
		
		log.info("security config..."); //간단한 로그 메시지 출력
		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		//permitAll()은 모든 사용자가 접근을 할수 있다는 의미이다.
		http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");
		//hasRole()은 특정건한을 가진 사람만이 접근할 수 있다는 의미이다.
		//manager로 접근했을때 자동으로 404연결됨
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		
		http.formLogin().loginPage("/login");

		/*
		 * http.formLogin()을 사용하면 별도의 로그인 페이지를 작성하지 않고도 스프링 시큐리티 내부에서
		 * 제공하는 자체 페이지가 띄워진다.
		 * 매핑주소는 /login이 된다.
		 * loginPage("/login")을 설정하면 login매핑주소가 실행되엇을 떄 스프링 시큐리티에서 제공하는
		 * 로그인페이지가 아닌  커스텀 즉 사용자 로그인 페이지로 이동되게 만들 수 있다.
		*/
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		//403 접근금지가 에러가 나면 accessDenied 매핑주소가 실행됨
		
		http.logout().logoutUrl("/logout").invalidateHttpSession(true); //세션 무효화 =>로그아
		
		http.rememberMe().key("zerock").userDetailsService(zerockUsersService)
		//rememberMe()에서 쿠키값을 암호화해 전달함으로 암호의 '키'를 지정해서 사용
		.tokenRepository(getJDBCRepository())
		.tokenValiditySeconds(60*60*24); //쿠키 유효시간을 초단위로 설정 -> 60초*60분*24시간 동안 쿠키 유효
	}//configure()
	
	//자동로그인과 연결 
	private PersistentTokenRepository getJDBCRepository() {
		/*
		 * SecurityConfig에서 rememberMe()를 처리할 때 JdbcTokenRepositoryImpl을 지정해줘야하는데
		 * 기본적으로 DataSource가 필요해 의존성을 주입한다.
		 */
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	
//	@Autowired //메모리상에서 로그인 인증처리
//	public void configureGlober(AuthenticationManagerBuilder auth) throws Exception{
//		//AuthenticationManageBuilder는 인증에 대한 다양한 처리가 가능하다.
//		
//		log.info("메모리상에 인증처리");
//		
//		auth.inMemoryAuthentication().withUser("manager").password("{noop}1111").roles("MANAGER");
//		//메서드 체이닝 방식
//		//사용자 아이디가 manager, 비번이 1111, 권한이 MANAGER인 경우는 manager.jsp로 이동
//		/*
//		 * Spring Security 4에서의 메모리 내의 인증은 비번을 암호화하지않고 일반텍스트로 저장할수있다.
//		 * Spring Security 5에서는 비번을 인코딩(암호화)해서 저장해야한다. =>{noop}를 이용(암호화하지않으면 오류 발생)
//		 */
//	}
}
