package com.mycompany.mytest.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C {
	
	private static final Logger logger = LoggerFactory.getLogger(C.class);
	
	private D d;
	public C(D d){
		
		logger.info("C 객체 생성");
		this.d = d;
	}
	
	public void method(){
		logger.info("C method 실행");
		d.method();
	}
	
}
