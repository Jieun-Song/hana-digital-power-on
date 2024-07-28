package net.daum.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(of="board_no") // 
@Table(name = "board") //board 테이블명 생성
public class BoardVO {
	/* 네임파라미터 이름과 빈클래스 변수명은 일치시킨다. */
	
	@Id // 구분
	private int board_no; //게시판 번호
	
	private String board_name; //글쓴이
	private String board_title; //글제목 
	private String board_pwd; //비번
	
	@Column(length = 4000) // 컬럼크기를 4000으로 설정
	private String board_cont; //글내용
	private int board_hit;//조회수 
	
	//계단형 계층형 게시판과 연관되는 관리자답글과 관련된 변수
	private int board_ref; //글 그룹번호 역할 => 원본글과 답글을 묶어주는 역할
	private int board_step; // 계층내 위치(원본글이면 0, 첫번째 답글이면 1, 두번째 답글이면 2...)
	
	private int board_level;//답변글 정렬순
	
	@CreationTimestamp //hibarnate의 특별한 기능으로 등록시점의 날짜값을 기록한다. mybatis로 실행할때는 구동안됨
	private Timestamp board_date;
	
}




