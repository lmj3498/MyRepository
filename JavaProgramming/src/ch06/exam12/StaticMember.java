package ch06.exam12;

public class StaticMember {
		//스태틱 필드
		static String field;
		//스태틱 블록
		static{
			System.out.println("StaticMember()실행");
			field = "자바";
		}
		//스태틱 메소드
		static void method(){
			
		}
		
}
