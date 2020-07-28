package com.pknu.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.user.dao.UserDao;
import com.pknu.user.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("age",27);
		return "home";
	}
	
	@RequestMapping("/List")
	public String list(Model model) {
		List<UserVo> list = userDao.getList();
		model.addAttribute("userList",list);
		return "list";
	}
	
	@RequestMapping("/WriteForm")
	public String writeFrom() {
		return "write";
	}
	
	@RequestMapping("/Write")
	public String write(UserVo vo, Model model) {
		userDao.addUser(vo);
		return "redirect:/List";
	}
	@RequestMapping("/View") // /View?tel=010
	public String view(String tel, Model model) {
		UserVo vo = userDao.getView(tel);
		model.addAttribute("user", vo);	
		return "view";
	}
	@RequestMapping("/Delete") ///Delete?tel=${user.tel}
	public String delete(String tel, Model model) {
		UserVo vo = userDao.getDelete(tel);
		return "delete";
	}
	
	
	@RequestMapping("/UpdateForm")
	public String updateForm(String tel, Model model) {
		//수정할 정보를 조회해서 전달
		UserVo vo = userDao.getView(tel);
		//전달
		model.addAttribute("user",vo);
		return "update";
	}
	@RequestMapping("/Update")
	public String update(UserVo vo) {
		userDao.updateUser(vo);
		return "redirect:/List";
	}
	
	
//	
//	@RequestMapping("/UpdateForm")
//	public String updateFrom(String tel, Model model) {
//		UserVo vo = userDao.getView(tel);
//		model.addAttribute("user", vo);	
//		return "updateFrom";
//	}
//	
//	@RequestMapping("/Update")
//	public String update(UserVo vo, Model model) {
//		userDao.getUpdate(vo);
//		return "redirect:/List";
//		
//	}
	
}
