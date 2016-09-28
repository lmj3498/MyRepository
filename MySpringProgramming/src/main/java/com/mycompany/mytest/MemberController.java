package com.mycompany.mytest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/join")
	public String join(){
		logger.info("join 페이지 입니다");
		return "member/join";
	}
	
	@RequestMapping("/login")
	public String login(){
		logger.info("login 페이지 입니다");
		return "member/login";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		logger.info("logout 페이지 입니다");
		return "member/logout";
	}
	
	@RequestMapping("/withdraw")
	public String withdraw(){
		logger.info("withdraw 페이지 입니다");
		return "member/withdraw";
	}
}
