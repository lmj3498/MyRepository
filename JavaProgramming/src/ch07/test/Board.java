package ch07.test;

public class Board {
	int bno;
	String title;
	String author;
	String content;
	int hitcount;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	Board(){}
	Board(int bno, String title,String author,String content,int hitcount){
		this.bno = bno;
		this.title = title;
		this.author = author;
		this.content = content;
		this.hitcount = hitcount;
	}
}
