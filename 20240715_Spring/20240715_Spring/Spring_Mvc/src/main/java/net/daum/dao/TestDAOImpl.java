package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.TestVO;

@Repository
public class TestDAOImpl implements TestDAO {

	@Autowired
	private SqlSession sqlSesstion;
	
	@Override
	public void insertTest(TestVO t) {
		this.sqlSesstion.insert("test_in", t);
	}
	
}
