package com.mycompany.mytest.exam09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceCImpl2 implements ServiceC{

	private static final Logger logger = LoggerFactory.getLogger(ServiceCImpl2.class);
	
	public ServiceCImpl2(){
		logger.info("ServiceCImpl2 객체 생성");
	}
	
	@Override
	public void method() {
		logger.info("ServiceCImpl2 method 실행");
		
	}

}
