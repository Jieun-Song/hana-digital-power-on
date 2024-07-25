package net.daum.vo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //엔티티빈 정의어 
@Table(name="tbl_members6") // tbl_members6이라는 테이블명 생성 
public class MemberVO {
	
	@Id //식별키인 기본키
	private String uid2;//회원아이디
	private String upw; //비번
	private String uname; //회원이름
	
	@Override
	public String toString() {
		return "MemberVO [uid2=" + uid2 + ", upw=" + upw + ", uname=" + uname + "]";
	}
	public String getUid2() {
		return uid2;
	}
	public void setUid2(String uid2) {
		this.uid2 = uid2;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(uid2, other.uid2);
	}
	@Override
	public int hashCode() {
		return Objects.hash(uid2);
	}
	
	
}
