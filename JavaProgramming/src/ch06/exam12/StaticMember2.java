package ch06.exam12;

public class StaticMember2 {
		
		static String field;
		String filed2;
		
		//스태틱 블록
		static{
			System.out.println("StaticMember()실행");
			field = "자바";
			//field2 = "자바";//객체가 없으므로 인스턴스 필드 초기화 불가
		}
		
		static void method(){
			
		}
		
		void method2(){
			field = "자바";
			filed2 = "자바";//인스턴스 메소드 안에서는 스태틱 필드값 초기화 가능
					
					
		}
		
		public static void main(String[] args){
			
			field = "자바";
			//field2 = "자바";
			
			method();
			//method2();
			
			StaticMember2 sm = new StaticMember2();
			sm.filed2 = "자바";
			sm.method2();
			
		}
}
