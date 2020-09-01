package com.myweb.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.myweb.persistence.MainDao;


@Service
public class MainServiceImpl implements MainService {
	
	@Inject
	private MainDao mainDao;
	
	//연결 테스트
	@Override
	public String connectTest() throws Exception {		
		return mainDao.connectTest();
	}
	
	// 유저 닉네임, 아이디 얻어오기
	/*
	@Override
	public UserNickAndId getUserNickAndId(int user_num) throws Exception {
		return articleDao.getUserNickAndId(user_num);
	}
	 */
	
	
	// 판매 등록
	/*
	@Override
	public void insertArticle(ArticleVo vo) throws Exception {
		articleDao.insertArticle(vo); 
	}
	*/
	
	// 전체 상품보기
	/*
	@Override
	public List<ArticleVo> getArticle_all(int page) throws Exception {
		return articleDao.getArticle_all(page);
	}
	*/
	

}
