package com.mycompany.myapp.exam12.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dao.MemberDao;
import com.mycompany.myapp.exam12.dto.Member;



@Component
public class Exam12Service {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Exam12Service.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private MemberDao dao;
	
	public void join(Member member) {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();//커넥션 풀로부터 커넥션 대여
			dao.setConn(conn);// 커넥션 세터 주입
			int rowNo = dao.insert(member);
			
			logger.info(rowNo + " 행이 저장됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();//커넥션 풀에 커넥션 반납(연결을 끊겠다는 의미가 아님)
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
