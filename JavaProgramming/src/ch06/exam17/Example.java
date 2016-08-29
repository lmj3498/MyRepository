package ch06.exam17;

public class Example {

	public static void main(String[] args) {
		Member m1 = new Member("angel");
		
		//m1.mid = "white";//막아야 하는 경우
		//System.out.println(m1.mid);
		System.out.println(m1.getMid());
		
		//m1.height = -100.0;
		m1.setMheight(100.0);
	}

}
