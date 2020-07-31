package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.PdsVo;

public interface PdsDao {

	List<PdsVo> getPdslist(HashMap<String, Object> map);

	void setWrite(HashMap<String, Object> map);

	List<PdsVo> getView(HashMap<String, Object> map);

	
}
