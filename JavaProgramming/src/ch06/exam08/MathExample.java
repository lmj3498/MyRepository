package ch06.exam08;

public class MathExample {

	public static void main(String[] args) {
		Math math = new Math();
		math.printInfo("수학 객체가 생성됨~");
		math.max(0, 1);//리턴 타입도 이렇게 쓰기만 하는 것도 오류는 아님
		int result = math.max(0, 1);
		
		math.printInfo(String.valueOf(math.max(0, 1)));
		
		
		int[] values = {10,20,30,40,50};
		double result1 = math.avg1(values);
		System.out.println(result1);
		double result2 = math.avg2(10,20,30,40,50);
		System.out.println(result2);
		
	}

}
