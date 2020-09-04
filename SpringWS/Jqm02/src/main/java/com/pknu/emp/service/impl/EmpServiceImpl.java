package com.pknu.emp.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.emp.dao.EmpDao;
import com.pknu.emp.service.EmpService;
import com.pknu.emp.vo.EmpVo;

@Service("empService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<EmpVo> getList(HashMap<String, Object> map) {
		
		List<EmpVo> empList = empDao.getList(map); 
		return empList;
	}

	@Override
	public void addEmp(HashMap<String, Object> map) {
		
		empDao.addEmp( map );
		
	}

}
