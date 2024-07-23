package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.TestService;
import net.daum.vo.TestVO;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/test_write")
	public void test_write() {
//		return new ModelAndView("test/test_write");
	}
	
	@PostMapping("/test_write_ok")
	public void test_write_ok(TestVO t) {
		this.testService.insertTest(t);
	}
}
