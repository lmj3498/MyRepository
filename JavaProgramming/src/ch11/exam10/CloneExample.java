package ch11.exam10;

import java.util.Arrays;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		int[] arr1 = { 1, 2, 3 };

		// 배열 복사 방법4
		int[] arr2 = arr1.clone();
		System.out.println(arr1 == arr2);
		System.out.println(Arrays.equals(arr1, arr2));
		
		Member m1 = new Member("hong", "길동");
		//System.out.println(m1.toString());
		System.out.println(m1);//이렇게만 해도 자동으로 toString()호출함!!
		Member m2 = (Member) m1.clone();
		System.out.println(m1 == m2);
		System.out.println(m2);
		

	}

}

class Member implements Cloneable{
	String mid;
	String mname;
	int age;
	String[] hobbys;
	
	
	Member(String mid, String mname) {
		this.mid = mid;
		this.mname = mname;
	}

	@Override
	public String toString() {
		return mid + ":" + mname;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
}