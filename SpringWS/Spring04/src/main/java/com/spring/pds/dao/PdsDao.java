package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.pds.vo.PdsVo;

public interface PdsDao {

	void setWrite(HashMap<String, Object> map);

	List<PdsVo> getList(HashMap<String, Object> map);

}
