package ch06.exam12;

public class Example {

	public static void main(String[] args) {
		//Instance Member 사용
		InstanceMember im = new InstanceMember();
		im.field = "자바";
		im.method();
		System.out.println(im.field);
		
		//Static Member 사용
		//StaticMember.field = "자바";
		StaticMember.method();
		//StaticMember sm = null;
		System.out.println(StaticMember.field);
	}

}
