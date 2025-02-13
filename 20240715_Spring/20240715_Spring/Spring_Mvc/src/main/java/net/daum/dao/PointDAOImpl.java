package net.daum.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PointDAOImpl implements PointDAO {

	@Autowired
	private SqlSession sqlSession;

	@Transactional
	@Override
	public void updatePoint(String sender, int point) {
		Map<String, Object> pm = new HashMap<>();
		//업캐스팅... HashMap의 제네릭 타입 생략 
		pm.put("sender", sender);//키,값 쌍으로 저장, 보낸 사람을 저장
		pm.put("point", point);//포인트 점수
		this.sqlSession.update("pointUp", pm);
		//pointUp은 point.xml에서 사용할 유일 아이디
		
				
	}
}
