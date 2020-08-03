package com.spring.pds.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.spring.pds.vo.PdsVo;

public interface PdsService {

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);

	List<PdsVo> getList(HashMap<String, Object> map) ;

	
}
