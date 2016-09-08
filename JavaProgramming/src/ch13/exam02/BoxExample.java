package ch13.exam02;

import java.util.Date;

public class BoxExample {

	public static void main(String[] args) {
		
		Box<String> box1 = new Box<String>();
		box1.setItem("홍길성");
		String name = box1.getItem();
		
		Box<Integer> box2 = new Box<Integer>();
		box2.setItem(10);//new Integer(10);
		int value = box2.getItem();
		
		Box<Date> box3 = new Box<Date>();
		box3.setItem(new Date());//new Integer(10);
		Date date = box3.getItem();
		
		

	}

}
