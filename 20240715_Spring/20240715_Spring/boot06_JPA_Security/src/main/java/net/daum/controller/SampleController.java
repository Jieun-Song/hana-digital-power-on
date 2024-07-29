package net.daum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller // @Controller 애노테이션을 설정하면스프링 컨트롤러로 인식한다.
@Log 
public class SampleController {
	
	@GetMapping("/")
	public String index() {
		
		log.info("index이다.");
		
		return "index";//뷰페이지 경로는 /WEB-INF/views/index.jsp
	}

	@RequestMapping("/guest") // get or post로 접근하는 매핑주소를 처리, guest매핑주소 등록 
	public void guest() {//리턴타입이 없는 void형이면 매핑주소가 뷰페이지 파일명이 된다.
		//뷰페이지 경로는 /WEB-INF/views/guest.jsp

		log.info("guest");		
	}
	
	@RequestMapping("/manager")
	public void forManager() {
		log.info("manager");
	}
	
	@RequestMapping("/admin")
	public void forAdmin() {
		log.info("admin");
	}
}
