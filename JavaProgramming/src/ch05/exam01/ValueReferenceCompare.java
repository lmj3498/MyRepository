package ch05.exam01;

public class ValueReferenceCompare {

	public static void main(String[] args) {
		//값 비교
		int v1 = 100;
		int v2 = 200;
		System.out.println(v1 == v2);
		System.out.println(v1 != v2);
		System.out.println();
		
		int v3 = 100;
		int v4 = 100;
		System.out.println(v3 == v4);
		System.out.println(v3 != v4);
		System.out.println();
		
		//참조 비교(객체 비교)
		String r1 = new String("자바");
		String r2 = new String("자바");
		System.out.println(r1==r2);
		System.out.println(r1!=r2);
		System.out.println();
		
		//참조 비교(객체 비교)
		String r3 = "자바";
		String r4 = "자바";
		System.out.println(r3==r4);
		System.out.println(r3!=r4);
		System.out.println();
				
	}

}
