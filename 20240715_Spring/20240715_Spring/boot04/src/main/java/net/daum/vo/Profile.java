package net.daum.vo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@SequenceGenerator(//시퀀스 생성기
		name = "fno_seq1_gename", //시퀀스 제너레이터 이름
		sequenceName = "fno_seq1", //시퀀스 이름
		initialValue = 1, // 시퀀스 번호 시작값
		allocationSize = 1 //증가값 1
		)
@Table(name = "tbl_profile3")
public class Profile {
	//엔티티빈 클래스
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "fno_seq1_gename" // 설정한 sequence generator name
			)
	private int fno;
	private String fname;
	private boolean current2;
	@ManyToOne //다대일 연관관계
	private MemberVO member; // FK로 설정
	
	@Override
	public String toString() {
		return "Profile [fno=" + fno + ", fname=" + fname + ", current2=" + current2 + "]";
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(fname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(fname, other.fname);
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public boolean isCurrent2() {
		return current2;
	}

	public void setCurrent2(boolean current2) {
		this.current2 = current2;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
	}
	
	
	
}
