package net.daum.vo;

import lombok.Data;
import lombok.ToString;

@Data // 기본 생성자, cnaEqual(), equeals(), hashCode(), toString()
@ToString(exclude = {"val03"})  // exclude 속성을 사용해서 val03변수를배제시킨다.
public class SampleVO {
	private String val01;
	private String val02;
	private String val03;
	
	@Override
	public String toString() {
		return "SampleVO [val01=" + val01 + ", val02=" + val02 + "]";
	}
	public String getVal01() {
		return val01;
	}
	public void setVal01(String val01) {
		this.val01 = val01;
	}
	public String getVal02() {
		return val02;
	}
	public void setVal02(String val02) {
		this.val02 = val02;
	}
	public String getVal03() {
		return val03;
	}
	public void setVal03(String val03) {
		this.val03 = val03;
	}
	
	
	
		
}
