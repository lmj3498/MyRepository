package com.mycompany.myapp.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam09")
public class Exam09Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam09Controller.class);

	public Exam09Controller(){
		logger.info("Exam09Controller 객체 생성");
	}
	
	private A a;
	public void setA(A a) {
		logger.info("set-A() 실행");
		this.a = a;
	}
	
	private B b;
	public void setB(B b) {
		logger.info("set-B() 실행");
		this.b = b;
	}
	
	private ServiceA serviceA;
	public void setServiceA(ServiceA serviceA) {
	
		logger.info("set-serviceA() 실행");
		this.serviceA = serviceA;
	}
	
	private ServiceB serviceB;
	public void setServiceB(ServiceB serviceB){
		logger.info("set-serviceB() 실행");
		this.serviceB = serviceB;
	}

	private ServiceC serviceC;
	public void setServiceC(ServiceC serviceC) {
		logger.info("set-serviceC() 실행");
		this.serviceC = serviceC;
	}
	
	private ServiceD serviceD;
	public void setServiceD(ServiceD serviceD) {
		logger.info("set-serviceD() 실행");
		this.serviceD = serviceD;
	}
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 처리");
		return "exam09/index";
	}
	
	@RequestMapping("/method1")
	public String method1(){
		
		a.method();
		b.method();
		serviceA.method();
		serviceB.method();
		serviceC.method();
		serviceD.method();
		
		logger.info("method1 처리");
		return "redirect:/exam09/index";
	}
	
}
