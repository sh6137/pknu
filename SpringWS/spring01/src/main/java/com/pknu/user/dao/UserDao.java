package com.pknu.user.dao;

import java.util.List;

import com.pknu.user.vo.UserVo;

public interface UserDao {
	public void addUser(UserVo vo);

	public List<UserVo> getList();

	public UserVo getView(String tel);

	public UserVo getDelete(String tel);

	public void updateUser(UserVo vo);

//	public UserVo getUpdate(String tel, String name);

//	public void getUpdate(UserVo vo);
}
