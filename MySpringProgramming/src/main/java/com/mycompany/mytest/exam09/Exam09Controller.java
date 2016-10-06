package com.mycompany.mytest.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);
	
	private A a;
	
	public void setA(A a) {
		this.a = a;
		logger.info("A 세터 실행");
	}

	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam09/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		
		a.method();
		
		
		logger.info("Exam09Controller method 처리");
		return "redirect:/exam09/index";
	}
}
