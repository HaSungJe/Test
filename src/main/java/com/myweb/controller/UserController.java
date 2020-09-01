package com.myweb.controller;

import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myweb.domain.UserVo;
import com.myweb.service.UserService;
import com.myweb.util.util;


@Controller
public class UserController {
	@Inject
	private UserService userService;
	
	@Inject
	private util util;
	
	/* 회원가입 페이지 */
	@RequestMapping(value = "/user/sign", method = RequestMethod.GET)
	public String sign(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		model.addAttribute("pageCode", "SIGN");
		return "user/sign";
	}	
	
	/* 로그인 페이지 */
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) throws Exception {
		model.addAttribute("pageCode", "LOGIN");
		return "user/login";
	}	
	
	/* ID 중복체크 */
	@RequestMapping(value = "/user/checkId", method = RequestMethod.GET)
	public @ResponseBody int checkId(String id) throws Exception {
		return userService.checkId(id);
	}
	
	/* 별명 중복체크 */
	@RequestMapping(value = "/user/checkSubname", method = RequestMethod.GET)
	public @ResponseBody int checkSubname(String id) throws Exception {
		return userService.checkId(id);
	}
	
	/* 회원가입 Run */
	@RequestMapping(value = "//user/signRun", method = RequestMethod.POST)
	public String signRun(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model, UserVo userVo, HttpSession session) throws Exception {
		/*
		 * signCheck
		 * 0 : 근원적 에러
		 * 1 : 계정등록
		 * 2 : ID중복 
		 * 3 : 계정등록 도중 실패
		 */
		int signCheck = userService.sign(userVo);
		String page = "";
		String message = "";
		
		userVo.setRip(util.getIp(request));

		
		if(signCheck == 0) {
			page = "/user/sign";
			message = "회원가입을 진행하는 도중 에러가 발생하였습니다. 올바른 경로로 다시 시도해주세요.";
		} else if(signCheck == 1) {
			page = "index";
			message = "회원 가입이 완료되었습니다.";
		}  else if(signCheck == 2) {
			page = "/user/sign";
			message = "ID가 중복되어 회원 가입이 원할히 진행되지 않았습니다. 다시 시도해 주세요.";
		}  else if(signCheck == 3) {
			page = "/user/sign";
			message = "회원가입을 진행하는 도중 에러가 발생하였습니다. 올바른 경로로 다시 시도해주세요.";
		} 
		session.setAttribute("message", message);
		
		return page;
	}
	
}






