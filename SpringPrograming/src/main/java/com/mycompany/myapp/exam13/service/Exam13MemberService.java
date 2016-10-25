package com.mycompany.myapp.exam13.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam13.dao.Exam13MemberDao;
import com.mycompany.myapp.exam13.dto.Member;


@Component
public class Exam13MemberService {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Exam13MemberService.class);
	
	//jdbc 템플릿 사용할 때 지워짐
	/*@Autowired
	private DataSource dataSource;*/
	
	@Autowired
	private Exam13MemberDao dao;
	
	public void join(Member member) {
		logger.info("join 처리");
		int rowNo = dao.insert(member);
		logger.info(rowNo + " 행이 저장됨");
		
	}

	public Member info(String mid) {
		logger.info("info 처리");
		Member member = dao.selectByMid(mid);
		return member;
	}

}
