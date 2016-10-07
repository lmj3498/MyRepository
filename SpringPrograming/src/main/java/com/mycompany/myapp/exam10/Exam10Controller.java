package com.mycompany.myapp.exam10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam10")
public class Exam10Controller {

	private static final Logger logger = LoggerFactory.getLogger(Exam10Controller.class);
	
	private G g;
	
	@Autowired
	public void setG(G g){
		logger.info("setG() 실행");
		this.g = g;
	}
	
	private H h;
	@Autowired
	public void setH(H h){
		logger.info("setH() 실행");
		this.h = h;
	}
	
	private Service service;
	@Autowired
	public void setService(Service service){
		this.service = service;
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam10/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		logger.info("method1 처리");
		g.method();
		h.method();
		service.method();
		return "redirect:/exam10/index";
	}
	
}
