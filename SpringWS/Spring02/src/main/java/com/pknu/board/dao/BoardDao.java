package com.pknu.board.dao;

import java.util.List;

import com.pknu.board.vo.BoardVo;

public interface BoardDao {
	public List<BoardVo> getBoardList();

	public BoardVo getContent(int idx);


	public void addBoard(BoardVo vo);

	public void deleteBoard(int idx);

	public void updateBoard(BoardVo vo);

	public void setIdx(int idx);
	
}
