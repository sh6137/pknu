package com.pknu.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pknu.board.dao.BoardDao;
import com.pknu.board.vo.BoardVo;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

	//SqlSessionFactory 사용 db 연결 사용
	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<BoardVo> getBoardList() {
		List<BoardVo> list = sqlSession.selectList("Board.BoardList");
		return list;
	}


	@Override
	public BoardVo getContent(int idx) {
		BoardVo boardVo = sqlSession.selectOne("Board.BoardContent",idx);
		return boardVo;
	}

	@Override
	public void addBoard(BoardVo vo) {
		sqlSession.insert("Board.BoardWrite",vo);
	}


	@Override
	public void deleteBoard(int idx) {
		sqlSession.delete("Board.BoardDelete",idx);
	}


	@Override
	public void updateBoard(BoardVo vo) {
		sqlSession.update("Board.BoardUpdate",vo);
	}


	@Override
	public void setIdx(int idx) {
		sqlSession.update("Board.BoardIdxSer",idx);
	}

}
