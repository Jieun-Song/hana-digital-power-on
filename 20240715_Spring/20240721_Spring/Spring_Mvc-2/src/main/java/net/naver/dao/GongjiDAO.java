package net.naver.dao;

import java.util.List;

import net.naver.vo.GongjiVO;

public interface GongjiDAO {

	List<GongjiVO> getGongjiList(GongjiVO g);

	void insertGongji(GongjiVO g);

}
