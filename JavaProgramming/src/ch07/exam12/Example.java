package ch07.exam12;

public class Example {

	public static void main(String[] args) {
		Theater cgv = new Theater();
		
		Adult a = new Adult();
		Student s = new Student();
		a.ssn = "123456-12345670";
		s.sno = "2016030105";
		
		cgv.check(a);
		cgv.check(s);
		
	}

}
