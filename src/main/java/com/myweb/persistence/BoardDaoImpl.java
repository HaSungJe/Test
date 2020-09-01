package com.myweb.persistence;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.domain.BoardListVo;


@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlSession;
	
	final static String NAMESAPCE = "com.myweb.mapper.boardMapper";

	// header 게시판 목록 얻기
	@Override
	public List<BoardListVo> getBoardList() throws Exception {
		return sqlSession.selectList(NAMESAPCE + ".getBoardList");
	}

	// 게시판 존재여부
	@Override
	public int checkBoardExist(String code) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".checkBoardExist", code);
	}	
	
	// 게시판 정보 가져오기
	@Override
	public BoardListVo getBoardInfo(String code) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".getBoardInfo", code);
	}	

	
	
}
