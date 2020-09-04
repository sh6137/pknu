package com.pknu.emp.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.emp.dao.EmpDao;
import com.pknu.emp.vo.EmpVo;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<EmpVo> getList(HashMap<String, Object> map) {
		
		List<EmpVo> empList  = sqlSession.selectList("GUESTS.List", map); 
		return  empList;
	}

	@Override
	public void addEmp(HashMap<String, Object> map) {
		
		sqlSession.insert("GUESTS.AddEmp", map); 
		
	}

}
