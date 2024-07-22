package net.daum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.daum.vo.SampleVO;

@RestController // @RestController 애노테이션을 사용하면 jsp같은 뷰 페이지를 만들지 않고도 REST 방식의 데이터처리를 위한 키, 값쌍의
//JSOn데이터, XML,문자열 객체등을 만들수있다.
@RequestMapping("/sample")//컨트롤러 자체 매핑주소 smaple 등록 
public class Sample2Controller {
	
	@GetMapping("/sendVO")
	public SampleVO sendVO() { // 리턴타입이 SampleVO 빈타입이면 해당 빈클래스 변수명이 JSON데이터의 키이름이 된다.
		
		SampleVO vo = new SampleVO();
		vo.setMno(7);
		vo.setFirstName("홍");
		vo.setLastName("길동" );
		
	    return vo;
		
	}//sendVO()

	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> list = new ArrayList<>();
		
		for (int i = 1; i <= 7; i++) {
			SampleVO vo = new SampleVO();
			
			vo.setMno(i);
			vo.setFirstName("신");
			vo.setLastName("사임당님");
			
			list.add(vo); // 컬렉션 추
		}
		
		return list;
	}//sendList()
	
	//키, 값 쌍의 Map 컬렉션 타입 JSON
	@GetMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		Map<Integer, SampleVO> map = new HashMap<>();
		for (int i = 1; i<=3; i++) {
				SampleVO vo = new SampleVO();
				vo.setMno(i);
				vo.setFirstName("홍");
				vo.setLastName("길동");
				
				map.put(i, vo);//컬렉션 맵에 키값 쌍으로 저
			}
		return map;
	}//sendMap()
	
	//나쁜 상태코드 전송
	@RequestMapping("/sendError")
	public ResponseEntity<Void> sendError(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		//나쁜 상태 코드 400이 전송된다.
	}//sendEror()
	
	//정상적인 JSON 데이터와 404(파일없음 에러) 나쁜 상태코드를 함꼐 브라우저로 전송
	@GetMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> SendListNot(){
		List<SampleVO> list = new ArrayList<>();
		
		for (int i=1;i<=3;i++) {
			SampleVO vo = new SampleVO();
			
			vo.setMno(i);
			vo.setFirstName("이");
			vo.setLastName("순신");
			
			list.add(vo);
		}
		return new ResponseEntity<List<SampleVO>>(list, HttpStatus.NOT_FOUND);//NOT_FOUND가 404 나쁜코
	}//sendErrorNot()
	
}
