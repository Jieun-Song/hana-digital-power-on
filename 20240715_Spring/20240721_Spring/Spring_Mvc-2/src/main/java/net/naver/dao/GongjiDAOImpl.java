package net.naver.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import net.naver.vo.GongjiVO;

public class GongjiDAOImpl implements GongjiDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<GongjiVO> getGongjiList(GongjiVO g) {
		return this.sqlSession.selectList("g_list",g);
	}

	@Override
	public void insertGongji(GongjiVO g) {
		this.sqlSession.insert("gongji_in", g);
		
	}


}
