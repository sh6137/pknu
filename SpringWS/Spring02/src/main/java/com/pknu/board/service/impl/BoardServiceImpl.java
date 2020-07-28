package com.pknu.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.board.dao.BoardDao;
import com.pknu.board.service.BoardService;
import com.pknu.board.vo.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<BoardVo> getBoardList() {
		//db와 직접관련없는 추가 코딩기재
		return boardDao.getBoardList();
	}

	@Override
	public BoardVo getContent(int idx) {
		BoardVo boardVo = boardDao.getContent(idx);
		return boardVo;
	}


	@Override
	public void addBoard(BoardVo vo) {
		boardDao.addBoard(vo);
	}

	@Override
	public void deleteBoard(int idx) {
		boardDao.deleteBoard(idx);
		//삭제한 후 글번호 변경
		//boardDao.setIdx(idx);
		
	}

	@Override
	public void updateBoard(BoardVo vo) {
		boardDao.updateBoard(vo);
	}
	

}
