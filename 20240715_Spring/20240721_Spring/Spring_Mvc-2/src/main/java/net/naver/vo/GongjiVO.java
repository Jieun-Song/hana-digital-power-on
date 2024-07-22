package net.naver.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GongjiVO {

	private int no; // 공지사항 번
	private String name; //공지사항 작성자
	private String title; // 공지사항 제목
	private String cont; //공지사항 내용
	private int hit; //공지사항 조회수
	private String date; //등록날짜 
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}
