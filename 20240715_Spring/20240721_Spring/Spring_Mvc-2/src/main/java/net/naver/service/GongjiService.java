package net.naver.service;

import java.util.List;

import net.naver.vo.GongjiVO;

public interface GongjiService {

	List<GongjiVO> getGongjiList(GongjiVO g);

	void insertGongji(GongjiVO g);
	
}
