package com.pknu.post.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.post.dao.PostDao;
import com.pknu.post.vo.PostVo;

@Repository("postDao")
public class PostDaoImpl implements PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PostVo> getList(HashMap<String, Object> map) {
		List<PostVo> postList = sqlSession.selectList("Post.getList", map); 
		return postList;
	}

}
