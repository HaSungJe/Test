package com.myweb.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.myweb.domain.BoardListVo;
import com.myweb.persistence.BoardDao;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDao boardDao ;
	
	// header 게시판 목록 얻기
	@Override
	public List<BoardListVo> getBoardList() throws Exception {		
		return boardDao.getBoardList();
	}
	
	// 게시판 존재여부
	@Override
	public int checkBoardExist(String code) throws Exception {
		return boardDao.checkBoardExist(code);
	}
	
	// 게시판 정보 가져오기
	public BoardListVo getBoardInfo(String code) throws Exception {
		return boardDao.getBoardInfo(code);
	}



	
	

}
