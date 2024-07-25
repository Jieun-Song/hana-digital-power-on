package net.daum.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardVO;

@Repository
public interface BoardRepository extends JpaRepository<BoardVO, Integer> {
	
	public List<BoardVO> findBoardVOByTitle(String title);
	//쿼리 메서드가 find+엔티티빈클래스명+by+컬럼명=>제목으로 검색 
	
	public Collection<BoardVO> findByWriter(String writer);//쿼리메서드가 findBy+엔티티빈 변수명 

	public Collection<BoardVO> findByWriterContaining(String writer);
	//글쓴이에 대한 like % 검색어 %   =>    '%' + writer + '%'
	//sql문에서 '%'와일드 카드는 하나이상의 임의의 모르는 문자와 매핑대응, '_'와일드 카드는 하나의 모르는 문자와 매핑대응
	
	// like 쿼리메서드 형태/종류
	/*
		형태               ㅣ 쿼리메서드 
		--------------------------------------
		검색어+'%'         ㅣ StartingWith
		'%' + 검색어	   ㅣ EndingWith
		'%' + 검색어 + '%' ㅣ Containing
	*/
	
	public Collection<BoardVO> findByTitleContainingOrContentContaining(String title, String cont);
	// 조건 처리
	// '%'+ 제목검색어 + '%' OR '%' + 내용검색어 + '%'
	
	public Collection<BoardVO> findByTitleContainingAndBnoGreaterThan(String title, int num);
	//'%' + 제목 검색어 + '%' AND 게시판번호 > num
	
	public Collection<BoardVO> findByBnoGreaterThanOrderByBnoDesc(int bno);
	//bno > ? order by bno desc => 게시판번호가 특정 번호보다 크고 번호를 기준으로 내림차순 정렬  
	
	//JPQL문
	
	@Query("SELECT b FROM BoardVO b "
			+ "WHERE b.title like %?1% AND b.bno > 0 "
			+ "ORDER BY b.bno desc")
	public List<BoardVO> findByTitle(String title);
	//JPQL(JPA에서 사용ㅎ는 쿼리언어(Java Persistence Query Language의 약어)), JPQL문을 사용하면
	//실제 테이블명 대신 엔티티빈 클래스의 변수 즉 속성을 이용한다.
	//%?1%에서 ?1은 첫번째로 전달되는 파라미터 값을 칭한다.
	
	@Query("SELECT b FROM BoardVO b WHERE b.content LIKE %:content% AND b.bno>0 ORDER BY b.bno desc")
	public List<BoardVO> findByContent(@Param("content") String content);
	//:content는 @Param("content")와 연결된다.

	@Query("SELECT b.bno, b.title, b.writer, b.regdate FROM BoardVO b "
			+ "WHERE b.title LIKE %?1% AND b.bno>0 ORDER BY b.bno DESC")
	public List<Object[]> findByTitle2(String title);
	//원하는 컬럼만 검색하는 경우는 반환 제네릭 타입이 Object[]배열타입이라는 것이다. 



}
