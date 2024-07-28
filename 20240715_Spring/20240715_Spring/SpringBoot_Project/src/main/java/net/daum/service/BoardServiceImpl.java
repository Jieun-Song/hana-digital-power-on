package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardDAO {
	
	@Autowired
	private BoardDAO boardDao;
}
