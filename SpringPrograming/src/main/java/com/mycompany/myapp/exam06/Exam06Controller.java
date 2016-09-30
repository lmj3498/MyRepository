package com.mycompany.myapp.exam06;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam06")
public class Exam06Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam06Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		
		logger.info("index 요청 처리");
		return "exam06/index";
	}
	
	@RequestMapping("/method1")
	public String method1(HttpServletRequest request){
		//클라이언트의 IP 얻기
		logger.info("WebClient IP: "+request.getRemoteAddr());
		//클라이언트의 브라우저 종류 얻기
		logger.info("WebClient 종류: "+request.getHeader("User-Agent"));
		if(request.getHeader("User-Agent").contains("Chrome")){
			logger.info("브라우저 종류 : 크롬");
		}else if(request.getHeader("User-Agent").contains("Trident/7.0")){
			logger.info("브라우저 종류 : 인터넷 익스플로러 11");
		}else if(request.getHeader("User-Agent").contains("MSIE")){
			logger.info("브라우저 종류 : 인터넷 익스플로러 10 이하");
		}
		//요청 파라미터 값 얻기
		logger.info("mid : " +request.getParameter("mid"));
		logger.info("mname : " +request.getParameter("mname"));
		
		//쿼리 문자열 얻기
		logger.info("쿼리 문자열 : " +request.getQueryString());
		
		//쿼리 문자열 얻기
		logger.info("요청 URI : " +request.getRequestURI());
		logger.info("요청 URL : " +request.getRequestURL());
		logger.info("요청 방식 : " +request.getMethod());
		logger.info("시스템 파일 경로 : " +request.getRealPath("/WEB-INF/image/photo.jpg"));
		logger.info("시스템 파일 경로 : " +request.getServletContext().getRealPath("/WEB-INF/image/photo.jpg"));
				
		
		logger.info("index 요청 처리");
		return "exam06/index";
	}
}
