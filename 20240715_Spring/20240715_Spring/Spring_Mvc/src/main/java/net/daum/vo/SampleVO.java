package net.daum.vo;

import lombok.Getter;
import lombok.Setter;


public class SampleVO {
	
	private int mno;
	private String firstName; //성
	private String lastName; //이름 
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	
}
