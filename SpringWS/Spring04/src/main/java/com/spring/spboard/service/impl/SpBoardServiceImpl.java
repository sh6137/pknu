package com.spring.spboard.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.spboard.dao.SpBoardDao;
import com.spring.spboard.service.SpBoardService;
import com.spring.spboard.vo.SpBoardVo;

@Service("spBoardService")
public class SpBoardServiceImpl implements SpBoardService {

	@Autowired
	private SpBoardDao spBoardDao;

	@Override
	public List<SpBoardVo> getList() {
		List<SpBoardVo> spBoardList = spBoardDao.getList();
		return spBoardList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		spBoardDao.addBoard(map);
		
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("map:" + map);
		spBoardDao.delete(map);
		
	}

	@Override
	public List<SpBoardVo> getView(HashMap<String, Object> map) {
		List<SpBoardVo> list = spBoardDao.getView(map);
		return list;
	}

	@Override
	public void updateBoard(HashMap<String, Object> map) {
		spBoardDao.updateBoard(map);
		
	}

}
