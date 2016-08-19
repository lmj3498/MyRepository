package ch05.exam02;

public class ArrayCreateByNew {

	public static void main(String[] args) {
		int[] arr1 = new int[5];
		for(int i =0;i <arr1.length ;i++){
			System.out.println("arr1["+i+"] = "+arr1[i]);
		}
		System.out.println();
		double[] arr2 = new double[5];
		for(int i =0;i <arr1.length ;i++){
			System.out.println("arr1["+i+"] = "+arr2[i]);
		}
		
		System.out.println();
		boolean[] arr3 = new boolean[5];
		for(int i =0;i <arr1.length ;i++){
			System.out.println("arr1["+i+"] = "+arr3[i]);
		}
		
		
		System.out.println();
		String[] arr4 = new String[5];
		for(int i =0;i <arr1.length ;i++){
			System.out.println("arr1["+i+"] = "+arr4[i]);
		}
	}

}
