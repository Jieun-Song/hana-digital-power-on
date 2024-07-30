package net.daum.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_members7")
@EqualsAndHashCode(of = "mem_id") //equals(), hashCode(), canEqual() 메서드 자동 생성
public class MemberVO { // 회원 관리 엔티티빈 클래스
	
	@Id //유일키로 사용될 기본키(primary key) 컬럼 지정
	private String mem_id;//회원아이디
	
	private String mem_pwd; //회원비번
	private String mem_name; //회원이름
	
	@CreationTimestamp // 하이버네이트의 기능으로 가입날짜를 기록등록 
	private Timestamp mem_date;//가입날짜 
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 /*
	  * 일대다 연관관계를 지정한다.
	  *  cascade = CascadeType.ALL은 jpa에서 영속성 전이중에서 모든 변경에 대한 전이로서
	  *  모든 엔티티빈 상태 변화에 대해서 그와 연결된것들도 똑같이 변경하도록 하는 옵션이다.
	  *  
	  *  fetch= FetchType.EAGER는 tbl_members7과 tbl_member_roles7 두 테이블을 조회해야 하기 때문에
	  *  트랜잭션을 처리해 주거나,즉시 로딩을 이용해 조인하는 방법으로 처리해야 한다.
	  * 
	  * 권한 정보는 회원정보와 마찬가지로 필요한 경우가 많기 때문에 fetch 모드를 즉시 로딩으로 설정해야하낟.
	  * (조인은 두가지를 합쳐서 사용하는 것이기때문에.. 느리다. 따라서 즉시 로딩, 즉시실행하는 것으로 설정해야.)
	  * 
	  */
	@JoinColumn(name = "member") // 이미 존재하는 tbl_member_roles7 테이블에 member컬럼 추가, fk로 추가설정됨
	private List<MemberRole> roles;
}
