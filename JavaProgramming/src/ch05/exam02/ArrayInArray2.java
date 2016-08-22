package ch05.exam02;

public class ArrayInArray2 {

	public static void main(String[] args) {
		int[][] scores = new int[2][];
		
		scores[0] = new int[2];
		scores[1] = new int[3];
		
		System.out.println(scores.length);
		System.out.println(scores[0].length);
		System.out.println(scores[1].length);

		System.out.println("for문 이용");
		for(int i = 0;i<scores.length;i++){
			for(int j=0;j<scores[i].length;j++){
				System.out.println(scores[i][j]);
			}
			System.out.println();
		}
	}

}
