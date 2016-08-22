package ch05.exam02;

public class ArrayInArray3 {

	public static void main(String[] args) {
		int[][] scores = {{2,3,4},{5,6,7,8}};
		
		System.out.println(scores.length);
		System.out.println(scores[0].length);
		System.out.println(scores[1].length);
		System.out.println();
		
		System.out.println("for문 이용");
		for(int i = 0;i<scores.length;i++){
			for(int j=0;j<scores[i].length;j++){
				System.out.println(scores[i][j]);
			}
			System.out.println();
		}
		
	}

}
