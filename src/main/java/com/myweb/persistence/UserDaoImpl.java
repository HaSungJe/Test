package com.myweb.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.domain.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
	@Inject
	private SqlSession sqlSession;
	
	final static String NAMESAPCE = "com.myweb.mapper.userMapper";
	
	/* ID 중복체크 */
	@Override
	public int checkId(String id) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".checkId", id);
	}
	
	/* 별명 중복체크 */
	@Override
	public int CheckSubname(String subname) throws Exception {
		return sqlSession.selectOne(NAMESAPCE + ".CheckSubname", subname);
	}

	/* 회원가입 */
	@Override
	public int sign(UserVo userVo) throws Exception {
		return sqlSession.insert(NAMESAPCE + ".sign", userVo);
	}


}
