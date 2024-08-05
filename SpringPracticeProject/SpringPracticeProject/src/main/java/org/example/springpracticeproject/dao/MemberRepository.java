package org.example.springpracticeproject.dao;

import org.example.springpracticeproject.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<MemberVO,String> {

}
