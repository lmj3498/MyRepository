package ch06.exam06;

public class Board {
	//Field
	int no;//게시물 번호
	String title;//제목
	String content;//내용
	String writer;//글쓴이
	int hitcount;//조회수
	
	//Constructor Overloading
	//매개변수의 수가 달라야 한다
	//매개변수의 타입이 달라야 한다
	Board(){}
	Board(int no){}
	Board(int no, String title){}
	Board(String title, int no){}
	Board(int no, String title, String content){}
	Board(int no, String title, String content, String writer){}
	Board(int no, String title, String content, String writer, int hitcount){}
	
	
	//Method
	
}
