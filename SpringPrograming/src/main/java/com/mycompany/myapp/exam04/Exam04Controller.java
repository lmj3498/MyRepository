package com.mycompany.myapp.exam04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam04Controller.class);
	
	@RequestMapping("/index")
	public String index(){
		logger.info("index 요청 처리");
		return "exam04/index";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		logger.info("joinForm 요청 처리");
		return "exam04/joinform";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member){
		
		logger.info("mid : "+member.getMid());
		
		/*String name = member.getMname();
		try {
			name = new String(name.getBytes("8859_1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {e.printStackTrace();}
		logger.info("mname : "+name);*/
		
		logger.info("mname : "+member.getMname());
		logger.info("mpassword : "+member.getMpassword());
		logger.info("memail : "+member.getMemail());
		logger.info("mtel : "+member.getMtel());
		logger.info("mjob : "+member.getMjob());
		logger.info("mskill : "+Arrays.toString(member.getMskill()));
		logger.info("maddress1 : "+member.getMaddress1());
		logger.info("maddress2 : "+member.getMaddress2());
		logger.info("mbirth : "+member.getMbirth());

		
		logger.info("join 요청 처리");
		return "exam04/index";
	}
}
