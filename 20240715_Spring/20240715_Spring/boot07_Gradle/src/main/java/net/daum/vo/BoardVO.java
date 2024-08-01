package net.daum.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO { // tbl_board 게시판 테이블 컬럼명 과 일치 하는 변수명을 정의
	private int bno;//게시판 번호
	private String writer;//글쓴이
	private String title;//글제목
	private String content;//글내용
	private int viewcnt; //조회수
	private String regdate; // 등록날짜
	
	//페이징 쪽나누기 관련변수
	private int startrow;//시작행 번호
	private int endrow;//끝행 번호 
	
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
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
//	public int getReplycnt() {
//		return replycnt;
//	}
//	public void setReplycnt(int replycnt) {
//		this.replycnt = replycnt;
//	}

}
