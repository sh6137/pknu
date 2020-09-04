package com.spring.pds.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.pds.vo.PdsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService{

	@Autowired
	private PdsDao pdsDao;


	@Override
	public List<PdsVo> getPdsList(HashMap<String, Object> map) {
		List<PdsVo> pdsList  = pdsDao.getPdsList( map );
		return pdsList;
	}

}
