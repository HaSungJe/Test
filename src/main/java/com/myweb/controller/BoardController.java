package com.myweb.controller;

import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.myweb.domain.BoardListVo;
import com.myweb.service.BoardService;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	/* 게시판 목록 */
	@RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
	public @ResponseBody List<BoardListVo> getBoardList() throws Exception {
		return boardService.getBoardList();
	}
	
	
	
	
	/* 게시판 */
	@RequestMapping(value = "/board/{board_code}", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, @PathVariable("board_code") String board_code, Locale locale, Model model) throws Exception {
		
		// 1. board_code값의 게시판이 존재하는지 판단하여 페이지 분기처리
		int checkBoardExist = boardService.checkBoardExist(board_code);
		
		if(checkBoardExist > 0) {
			return "index";
		} else {
			return "error";
		}
	}	
	
}
