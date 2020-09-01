package com.myweb.persistence;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class MainDaoImpl implements MainDao{

	@Inject
	private SqlSession sqlSession;
	
	final static String NAMESAPCE = "com.myweb.mapper.mainMapper";

	// 연결 테스트
	@Override
	public String connectTest() throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".connectTest");
	}

	// 유저 닉네임, 아이디 얻어오기
	/*
	@Override
	public UserNickAndId getUserNickAndId(int user_num) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".getUserNickAndId", user_num);
	}
	*/
	
	
	
	// 판매 등록
	/*
	@Override
	public void insertArticle(ArticleVo vo) throws Exception {
		sqlSession.insert(NAMESAPCE + ".insertArticle", vo);
	}
	*/

	
	// 전체 상품보기
	/*
	@Override
	public List<ArticleVo> getArticle_all(int page) throws Exception {
		
		// rnum의 시작값(start), 끝값(end)
		int start = (page * 10) - 9;
		int end= start + 9;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<ArticleVo> list = sqlSession.selectList(NAMESAPCE + ".getArticle_all", map);
		return list;
	}
	*/
	
	
	
	
}
