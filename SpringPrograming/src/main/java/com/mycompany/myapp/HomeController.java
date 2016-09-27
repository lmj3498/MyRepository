package com.mycompany.myapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/")
	public String index() {
		System.out.println("home() 실행1");
		logger.info("home() 실행");
		
		
		return "index";
	}
	
}
