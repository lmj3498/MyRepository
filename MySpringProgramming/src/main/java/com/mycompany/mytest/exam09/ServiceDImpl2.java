package com.mycompany.mytest.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceDImpl2 implements ServiceC{

	private static final Logger logger = LoggerFactory.getLogger(ServiceDImpl2.class);
	
	public ServiceDImpl2(){
		logger.info("ServiceDImpl2 객체 생성");
	}
	
	@Override
	public void method() {
		logger.info("ServiceDImpl2 method 실행");
		
	}

}
