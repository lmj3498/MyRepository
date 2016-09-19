package ch15.test;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board> getBoardList(){
		List<Board> list = new ArrayList<>();
		list.add(0,new Board("제목1","내용1"));
		list.add(1,new Board("제목2","내용2"));
		list.add(2,new Board("제목3","내용3"));
		
		
		
		return list;
		
	}
}
