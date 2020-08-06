package com.spring.spboard.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.spboard.dao.SpBoardDao;
import com.spring.spboard.vo.SpBoardVo;

@Repository("spBoardDao")
public class SpBoardDaoImpl implements SpBoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SpBoardVo> getList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		sqlSession.selectOne("SpBoard.BoardList", map);
		List<SpBoardVo> spBoardList = (List<SpBoardVo>) map.get("result"); 
		return spBoardList;
	}

	@Override
	public void addBoard(HashMap<String, Object> map) {
		sqlSession.insert("SpBoard.BoardInsert", map);
		
	}

	@Override
	public void delete(HashMap<String, Object> map) {
		System.out.println("map:" + map);
		System.out.println("idx:" + map.get("idx"));
		sqlSession.delete("SpBoard.BoardDelete", map);		
	}

	@Override
	public List<SpBoardVo> getView(HashMap<String, Object> map) {
		sqlSession.selectList("SpBoard.BoardView", map);
		List<SpBoardVo> list = (List<SpBoardVo>) map.get("result"); 
		return list;
	}

	@Override
	public void updateBoard(HashMap<String, Object> map) {
		sqlSession.update("SpBoard.BoardUpdate", map);
		
	}

}
