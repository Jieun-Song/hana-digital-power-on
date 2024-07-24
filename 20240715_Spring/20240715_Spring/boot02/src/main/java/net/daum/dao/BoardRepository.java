package net.daum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.daum.vo.BoardVO;

@Repository
public interface BoardRepository extends CrudRepository<BoardVO,Integer>{
	
	
}
