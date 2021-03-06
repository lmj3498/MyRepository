package com.mycompany.myapp.exam11.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam11.dto.Board;

@Component
public class Exam11BoardDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Exam11BoardDao.class);
	
	public void insert(Board board){
		logger.info("insert 처리");
		logger.info(board.getBwriter());
		logger.info(board.getBtitle());
		logger.info(board.getBcontent());
		
	}
	
	public List<Board> selectList(){
		logger.info("selectList 처리");
		
		List<Board> list = new ArrayList<>();
		for(int i=1;i<=10;i++){
			Board board = new Board();
			board.setBwriter("글쓴이"+i);
			board.setBtitle("제목"+i);
			board.setBcontent("내용"+i);
			list.add(board);
		}
		
		return list;
	}
	
	public Board selectBoard(int bno){
		logger.info("selectBoard 처리");
		Board board = new Board();
		board.setBwriter("이명진");
		board.setBtitle("완전 존잘");
		board.setBcontent("너어어어어무 잘생김");
		return board;
	}

	public void update(Board board) {
		logger.info("update 처리");
		
	}

	public void delete(int bno) {
		logger.info("delete 처리");
		
	}
	
}
