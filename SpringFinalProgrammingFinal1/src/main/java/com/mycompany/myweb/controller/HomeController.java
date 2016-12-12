package com.mycompany.myweb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.service.OrderService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/")
	public String index(HttpSession session){
		logger.info("맨처음");
		return "index";
	}
}
