package com.pknu.post.dao;

import java.util.HashMap;
import java.util.List;

import com.pknu.post.vo.PostVo;

public interface PostDao {

	List<PostVo> getList(HashMap<String, Object> map);

}
