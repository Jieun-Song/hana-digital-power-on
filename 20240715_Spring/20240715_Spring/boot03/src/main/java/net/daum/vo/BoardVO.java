package net.daum.vo;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity // JPA를 다루는 entity Bean 클래
@SequenceGenerator(//시퀀스 생성기
		name = "bno_seq8_gename",// 시퀀스 제네레이터 이름
		sequenceName = "bno_seq8", // 시퀀스 이름
		initialValue = 1,//시작번호 값
		allocationSize = 1 //기본값 50, 1씩증가 
		)
@Table(name="tbl_boards3") // tbl_boards3 테이블을 생성한다.
public class BoardVO {

	@Id //기본키 설정 
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
			generator = "bno_seq8_gename" //시퀀스 generator의 이름
			)
	private int bno; // 번호
	private String writer; //작성자
	private String title; //제목
	
	@Column(length = 4000)//컬럼크기 지정 
	private String content; //글내용 
	
	@CreationTimestamp
	private Timestamp regdate;//등록날짜 
	
	@UpdateTimestamp // @CreationTimestamp와 UpdateTimestamp 하이브네이트 ORM프레임워크의 특별한 기
	private Timestamp updatedate;//수정날짜 

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", writer=" + writer + ", title=" + title + ", content=" + content + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}
	
	
	
}
