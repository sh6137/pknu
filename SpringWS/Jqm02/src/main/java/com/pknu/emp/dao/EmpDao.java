package com.pknu.emp.dao;

import java.util.HashMap;
import java.util.List;

import com.pknu.emp.vo.EmpVo;

public interface EmpDao {

	List<EmpVo> getList(HashMap<String, Object> map);

	void addEmp(HashMap<String, Object> map);

}
