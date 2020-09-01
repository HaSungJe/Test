package com.myweb.persistence;

import com.myweb.domain.UserVo;

public interface UserDao {
	/* ID 중복체크 */
	public int checkId(String id) throws Exception;
	
	/* 별명 중복체크 */
	public int CheckSubname(String subname) throws Exception;

	/* 회원가입 */
	public int sign(UserVo userVo) throws Exception;
}
