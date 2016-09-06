package ch11.exam11;

public class Board implements Comparable{
	private int bno;
	private String title;
	
	public Board(int bno, String title) {
		this.bno = bno;
		this.title = title;
	}

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

	@Override
	public int compareTo(Object o) {
		
		Board target = (Board) o;
		
		return target.bno - bno;
		//return  bno - target.bno;
	}
	@Override
	public String toString() {
		
		return title;
	}
	
}
