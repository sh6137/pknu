package com.pknu.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/Board/List")
	public String list(Model model) {
		List<BoardVo> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		return "list";
	}
	
	@RequestMapping("/Board/Content")
	public String content(int idx, Model model) {
		System.out.println(idx);
		BoardVo boardVo = boardService.getContent(idx);
		System.out.println(boardVo);
		model.addAttribute("boardVo",boardVo);
		return "content";
	}
	
	
	//새글쓰기 (입력)
	@RequestMapping("/Board/WriteForm")
	public String writeFrom() {
		return "write";
	}
	//새글쓰기
	@RequestMapping("/Board/Write")
	public String write(BoardVo vo) {
		boardService.addBoard(vo);
		return "redirect:/Board/List";
	}
	
	//삭제하기
	@RequestMapping("/Board/Delete")
	public String delete(int idx) {
		boardService.deleteBoard(idx);
		
		return "redirect:/Board/List";
	}
	/*
	//수정하기
	@RequestMapping("/Board/UpdateForm")
	public String updateForm(int idx,Model model) {
		BoardVo vo = boardService.getContent(idx);
		model.addAttribute("boardVo",vo);
		return "update";
	}
	*/
	/*
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView updateForm(int idx) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = boardService.getContent(idx);
		mv.setViewName("update");
		mv.addObject("boardVo", vo);
		
		return mv;
	}
	*/
	
	@RequestMapping("/Board/UpdateForm")
	public ModelAndView updateForm(BoardVo boardVo) {
		ModelAndView mv = new ModelAndView();
		BoardVo vo = boardService.getContent(boardVo.getIdx());
		mv.setViewName("update");
		mv.addObject("boardVo", vo);
		
		return mv;
	}
	
	
	//수정하기(db저장)
		@RequestMapping("/Board/Update")
		public String update(BoardVo vo) {
			boardService.updateBoard(vo);
			return "redirect:/Board/Content?idx="+vo.getIdx();
		}
}
