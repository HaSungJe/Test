package com.myweb.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.domain.UserVo;
import com.myweb.persistence.UserDao;
import com.myweb.util.util;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDao userDao;
	
	/* ID 중복체크 */
	@Override
	public int checkId(String id) throws Exception {	
		return userDao.checkId(id);
	}
	
	/* 별명 중복체크 */
	@Override
	public int checkSubname(String subname) throws Exception {
		return userDao.CheckSubname(subname);
	}
	
	/* 회원가입 */
	@Override
	public int sign(UserVo userVo) {
		try {
			int idCheck = userDao.checkId(userVo.getId());
			if(idCheck <= 0) {
				util util = new util();
				userVo.setPw(util.getSHA256(userVo.getPw()));
				int signCheck = userDao.sign(userVo);
				if(signCheck > 0) {
					return 1;
				} else {
					return 3;
				}	
			} else {
				return 2;
			}
		} catch (Exception e) {
			return 0;
		}
	}

}
