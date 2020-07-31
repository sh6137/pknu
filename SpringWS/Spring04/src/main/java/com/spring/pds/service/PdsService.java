package com.spring.pds.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface PdsService {

	void setWrite(HashMap<String, Object> map, HttpServletRequest request);
	
}
