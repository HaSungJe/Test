package com.myweb.service;

import java.util.List;

import com.myweb.domain.BoardListVo;


public interface BoardService {
	// header 게시판 목록 얻기
	public List<BoardListVo> getBoardList() throws Exception;
	
	// 게시판 존재여부
	public int checkBoardExist(String code) throws Exception;
	
	// 게시판 정보 가져오기
	public BoardListVo getBoardInfo(String code) throws Exception;
	
	
	
	// 물건등록
//	public void insertArticle(ArticleVo vo) throws Exception; 
	
	// 유저 닉네임, 아이디 얻어오기
//	public UserNickAndId getUserNickAndId(int user_num) throws Exception;
	
	// 전체글
//	public List<ArticleVo> getArticle_all(int page) throws Exception;
}
