package com.pknu.post.service;

import java.util.HashMap;
import java.util.List;

import com.pknu.post.vo.PostVo;

public interface PostService {

	List<PostVo> getList(HashMap<String, Object> map);

}
