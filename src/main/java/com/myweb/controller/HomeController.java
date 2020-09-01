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

import com.myweb.service.MainService;

@Controller
public class HomeController {

	@Inject
	private MainService mainService;
	
	/* 메인페이지 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws Exception {
		model.addAttribute("pageCode", "MAIN");
		return "index";
	}	
	
	/* 에러페이지 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model) throws Exception {
		model.addAttribute("connectTest", mainService.connectTest());
		return "error";
	}
	
	/* 메시지 세션 삭제 */
	@RequestMapping(value = "/session/del", method = RequestMethod.GET)
	public @ResponseBody void delSession(HttpServletRequest request, HttpServletResponse response,Locale locale, Model model, HttpSession session) {
		
	}
}
