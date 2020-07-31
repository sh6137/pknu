package com.spring.spboard.service;

import java.util.HashMap;
import java.util.List;

import com.spring.spboard.vo.SpBoardVo;

public interface SpBoardService {

	List<SpBoardVo> getList();

	void addBoard(HashMap<String, Object> map);

	void delete(HashMap<String, Object> map);

	List<SpBoardVo> getView(HashMap<String, Object> map);

	void updateBoard(HashMap<String, Object> map);

}
