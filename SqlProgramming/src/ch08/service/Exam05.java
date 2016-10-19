package ch08.service;

import java.util.Date;

import ch08.dao.BoardDao;
import ch08.dto.Board;

public class Exam05 {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		Board board = new Board();
		board.setBno(7);
		board.setBtitle("제목11");
		board.setBcontent("내용11");
		board.setBwriter("user11");
		board.setBhitcount(11);
		board.setBdate(new Date(1996,2,17));
		
		dao.update(board);
	}
}
