package com.mycompany.mytest.exam01;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam01")
public class Exam01Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam01Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청처리");
		return "exam01/index";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String boardForm(){
		
		
		
		logger.info("boardform 요청처리");
		return "exam01/boardform";
	}
	
	@RequestMapping(value="/board", method=RequestMethod.POST)
	public String board(Board board){
		
		logger.info("번	호 : "+ board.getBno());
		logger.info("제	목 : "+ board.getBtitle());
		logger.info("내	용 : "+ board.getBcontent());
		logger.info("글 쓴 이 : "+ board.getBwriter());
		logger.info("조 회 수 : "+ board.getBhitcount());
		logger.info("종	류 : "+ board.getBcharater());
		logger.info("게시분야 : "+ Arrays.toString(board.getBfield()));
		logger.info("게 시 일 : "+ board.getBday());
		
		
		
		logger.info("board 요청처리");
		return "exam01/index";
	}
}
