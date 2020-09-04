package com.pknu.emp.service;

import java.util.HashMap;
import java.util.List;

import com.pknu.emp.vo.EmpVo;

public interface EmpService {

	List<EmpVo> getList(HashMap<String, Object> map);

	void addEmp(HashMap<String, Object> map);

}
