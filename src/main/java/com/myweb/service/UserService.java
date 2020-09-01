package com.myweb.service;

import com.myweb.domain.UserVo;

public interface UserService {
	/* ID 중복체크 */
	public int checkId(String id) throws Exception;
	
	/* 별명 중복체크 */
	public int checkSubname(String subname) throws Exception;
	
	/* 회원가입 */
	public int sign(UserVo userVo) throws Exception;
}
