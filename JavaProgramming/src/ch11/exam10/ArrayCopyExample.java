package ch11.exam10;

import java.util.Arrays;

public class ArrayCopyExample {

	public static void main(String[] args) {
		char[] arr1 = { 'J', 'A', 'V', 'A' };
		System.out.println(Arrays.toString(arr1));

		// 배열 복사 방법1
		char[] arr2 = new char[arr1.length];

		for (int i = 0; i < arr1.length; i++) {//얕은 복사
			arr2[i] = arr1[i];
		}
		System.out.println(Arrays.toString(arr2));

		// 배열 복사 방법2
		char[] arr3 = new char[arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);//얕은 복사
		System.out.println(Arrays.toString(arr3));

		// 배열 복사 방법3
		char[] arr4 = Arrays.copyOf(arr1, arr1.length);//얕은 복사
		System.out.println(Arrays.toString(arr4));

		// 배열 복사 방법4
		int[] arrr1 = { 1, 2, 3 };
		int[] arr5 = arrr1.clone();//얕은 복사
		System.out.println(arrr1 == arr5);
		System.out.println(Arrays.equals(arrr1, arr5));
		//System.out.println(Arrays.deepEquals(arrr1, arr5));//그냥 만들어본거 1차원 배열에선 아님아님
	}

}
 