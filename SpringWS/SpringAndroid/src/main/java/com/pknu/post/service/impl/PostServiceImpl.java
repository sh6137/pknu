package com.pknu.post.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.post.dao.PostDao;
import com.pknu.post.service.PostService;
import com.pknu.post.vo.PostVo;

@Service("postService")
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public List<PostVo> getList(HashMap<String, Object> map) {
		
		List<PostVo> postList = postDao.getList(map); 
		return postList;
	}

}
