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
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardVO;

@Repository
public interface BoardRepository extends JpaRepository<BoardVO, Integer> {
	
	public List<BoardVO> findBoardVOByTitle(String title);
	//쿼리 메서드가 find+엔티티빈클래스명+by+컬럼명=>제목으로 검색 
	
	public Collection<BoardVO> findByWriter(String writer);//쿼리메서드가 findBy+엔티티빈 변수명 

}
