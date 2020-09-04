package com.pknu.emp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.emp.service.EmpService;
import com.pknu.emp.vo.EmpVo;

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/getemplist")
	public HashMap<String, Object> list(
		@RequestParam	HashMap<String, Object> map) {
		
		List<EmpVo> empList = empService.getList(map); 
		
		map.put("emplist", empList);
		return map;
	}
	
	@RequestMapping("/addEmp")
	public void addemp(
			@RequestParam	HashMap<String, Object> map) {
		
		empService.addEmp(map);
		
	}
}
